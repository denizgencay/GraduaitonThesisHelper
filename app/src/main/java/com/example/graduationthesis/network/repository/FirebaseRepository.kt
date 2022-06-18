package com.example.graduationthesis.network.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot


interface FirebaseRepository {

    fun appendLicensePlate(licencePlate: String?)

    fun getRegisteredPlates(): Task<DocumentSnapshot>

    fun matchLicencePlate(): DocumentReference

}