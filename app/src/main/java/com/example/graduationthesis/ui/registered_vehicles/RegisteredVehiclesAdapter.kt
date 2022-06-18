package com.example.graduationthesis.ui.registered_vehicles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationthesis.R
import com.example.graduationthesis.data.RegisteredVehicleModel
import kotlinx.android.synthetic.main.registered_vehicle_card.view.*

class RegisteredVehiclesAdapter: RecyclerView.Adapter<RegisteredVehiclesAdapter.ViewHolder>() {

    private var registeredVehicles: List<RegisteredVehicleModel>? = null

    fun setPlateList(registeredVehicles: List<RegisteredVehicleModel>){
        this.registeredVehicles = registeredVehicles
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val licensePlate = itemView.register_vehicle_card_text

        fun bind(data: RegisteredVehicleModel){
            licensePlate.text = data.plateNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.registered_vehicle_card,parent,false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        registeredVehicles?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return registeredVehicles?.size ?: 0
    }

}