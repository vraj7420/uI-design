package com.example.uiapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uiapp.R
import com.example.uiapp.adapter.VehicleTypeAdapter
import com.example.uiapp.model.VehicleTypeModel
import kotlinx.android.synthetic.main.activity_screen2.*
import java.util.*

class Screen2Activity : AppCompatActivity() {
    private val vehicleTypeList = ArrayList<VehicleTypeModel>()

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var btnNextForAdapter: Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)
        init()
        setListener()
    }

    private fun setListener() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
        btnNext.setOnClickListener {
            val intentScreen3=Intent(this,Screen3Activity::class.java)
            startActivity(intentScreen3)
        }
    }

    private fun init() {
        btnNextForAdapter = findViewById(R.id.btnNext)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        for (i in 1..10) {
            vehicleTypeList.add(
                VehicleTypeModel(
                    Uri.parse("android.resource://com.example.uiapp/drawable/ic_launcher_background")
                        .toString(), "Suv"
                )
            )
        }
        setVehicleTypeAdapter()
    }

    private fun setVehicleTypeAdapter() {
        val vehicleTypeAdapter = VehicleTypeAdapter(this, vehicleTypeList)
        rvVehicle.layoutManager = GridLayoutManager(this, 2)
        rvVehicle.adapter = vehicleTypeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_application, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            (android.R.id.home) -> {
                onBackPressed()
            }
            (R.id.close) -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}