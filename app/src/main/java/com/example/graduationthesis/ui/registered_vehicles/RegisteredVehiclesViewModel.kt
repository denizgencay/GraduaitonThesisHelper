package com.example.graduationthesis.ui.registered_vehicles

import com.example.graduationthesis.network.repository.FirebaseRepositoryImpl

class RegisteredVehiclesViewModel {

    private val firebaseRepository = FirebaseRepositoryImpl()

    fun getPlates() = firebaseRepository.getRegisteredPlates()

    fun matchPlates() = firebaseRepository.matchLicencePlate()


}