package com.example.graduationthesis.ui.vehicle_register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.graduationthesis.R
import kotlinx.android.synthetic.main.fragment_vehicle_register.*

class VehicleRegisterFragment : Fragment() {

    private var viewModel: VehicleRegisterViewModel = VehicleRegisterViewModel()
    private lateinit var plateString: String
    private lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vehicle_register, container, false)
        button = view.findViewById(R.id.register_vehicle)
        button.setOnClickListener{
            plateString = plate_text.text.toString()
            if (plateString.isNotEmpty()){
                viewModel.registerVehicle(plateString)
            }else{
                Toast.makeText(activity,"Lütfen Bir Plaka Giriniz", Toast.LENGTH_LONG).show()
            }
        }
        return view
    }
}