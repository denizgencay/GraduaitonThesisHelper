package com.example.graduationthesis.ui.registered_vehicles

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationthesis.R
import com.example.graduationthesis.data.RegisteredVehicleModel
import com.google.firebase.firestore.FieldValue
import kotlinx.android.synthetic.main.fragment_registered_vehicles.*


class RegisteredVehiclesFragment : Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerViewAdapter: RegisteredVehiclesAdapter
    private lateinit var recyclerView: RecyclerView
    private val viewModel = RegisteredVehiclesViewModel()
    private lateinit var builder: AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registered_vehicles, container, false)
        builder = AlertDialog.Builder(context)
        builder.setTitle("Plaka Tanındı Geçebilirsiniz")
        recyclerView = view.findViewById(R.id.register_vehicle_recyclerview)
        linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerViewAdapter = RegisteredVehiclesAdapter()
        recyclerView.adapter = recyclerViewAdapter
        initViewModel()
        return view
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        initViewModel()
    }

    private fun initViewModel(){
        viewModel.getPlates().addOnCompleteListener{
            val lists: ArrayList<RegisteredVehicleModel> = arrayListOf()
            val list: ArrayList<String> = it.result.data?.get("registered_plate_numbers") as ArrayList<String>
            for (item in list){
                lists.add(RegisteredVehicleModel(item))
            }
            recyclerViewAdapter.setPlateList(lists)
            recyclerViewAdapter.notifyDataSetChanged()

            viewModel.matchPlates().addSnapshotListener{snap, _ ->
               if (list.contains(snap?.data?.get("detected_plate_number"))){
                   builder.setMessage("Plaka: ${snap?.data?.get("detected_plate_number").toString()}")
                   builder.setPositiveButton("Onlayla") { dialog: DialogInterface, i: Int ->
                       viewModel.matchPlates().update("detected_plate_number", "")
                       dialog.dismiss()
                   }
                   builder.show()
               }
            }
        }
    }
}