package com.example.graduationthesis

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.graduationthesis.ui.ViewPagerAdapter
import com.example.graduationthesis.ui.registered_vehicles.RegisteredVehiclesFragment
import com.example.graduationthesis.ui.vehicle_register.VehicleRegisterFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(RegisteredVehiclesFragment(),"Kayıtlı Araçlar")
        adapter.addFragment(VehicleRegisterFragment(),"Araç Kayıt")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }

}