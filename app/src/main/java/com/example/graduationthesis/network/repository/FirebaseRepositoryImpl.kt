package com.example.graduationthesis.network.repository

import android.app.Activity
import com.example.graduationthesis.MainActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepositoryImpl : FirebaseRepository {

    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var documentReference = db.collection("data").document("plates")

    override fun appendLicensePlate(licencePlate: String?) {
        documentReference.update("registered_plate_numbers", FieldValue.arrayUnion(licencePlate))
    }

    override fun getRegisteredPlates(): Task<DocumentSnapshot> = documentReference.get()

    override fun matchLicencePlate(): DocumentReference = documentReference
/*    {
        val docRef = db.collection("data").document("plates")
        docRef.addSnapshotListener { snapshot, _ ->
            var detected: ArrayList<String> = snapshot?.get("detected_plate_numbers") as ArrayList<String>
            println(detected[detected.size - 1])
            //println(snapshot.get("registered_plate_numbers"))
            docRef.get().addOnCompleteListener{
                val list: ArrayList<String> = it.result.data?.get("registered_plate_numbers") as ArrayList<String>
                if (detected[detected.size - 1] == list[list.size - 1]){

                }
            }
        }
    }*/

}
