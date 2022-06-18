package com.example.graduationthesis.ui.vehicle_register

import com.example.graduationthesis.data.RegisteredVehicleModel
import com.example.graduationthesis.network.repository.FirebaseRepository
import com.example.graduationthesis.network.repository.FirebaseRepositoryImpl

class VehicleRegisterViewModel {

    private val firebaseRepository: FirebaseRepository = FirebaseRepositoryImpl()

    fun registerVehicle(licencePlate: String){
        firebaseRepository.appendLicensePlate(licencePlate)
    }

}