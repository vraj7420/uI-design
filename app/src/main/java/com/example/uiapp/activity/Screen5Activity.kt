package com.example.uiapp.activity

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uiapp.R
import com.example.uiapp.adapter.ServiceProviderAdapter
import com.example.uiapp.adapter.VerifyInfoAdapter
import com.example.uiapp.model.ServiceProviderModel
import com.example.uiapp.model.VerifyInfoModel
import kotlinx.android.synthetic.main.activity_screen5.*

class Screen5Activity : AppCompatActivity() {
    private val serviceProviderList = ArrayList<ServiceProviderModel>()
    private val verifyInfoList = ArrayList<VerifyInfoModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen5)
        init()
    }

    private fun init() {
        for (i in 1..10) {
            serviceProviderList.add(
                ServiceProviderModel(Uri.parse("android.resource://com.example.uiapp/drawable/ic_launcher_background").toString(),"Betending","$33/hr"))
        }
        setServiceProviderAdapter()
        for (i in 1..10) {
            verifyInfoList.add(VerifyInfoModel(Uri.parse("android.resource://com.example.uiapp/drawable/ic_launcher_background").toString(),"Verify Email"))
        }
        setVerifyInfoAdapter()

    }

    private fun setVerifyInfoAdapter() {
        val verifyInfoAdapter = VerifyInfoAdapter(this,verifyInfoList)
        rvVerifyInfo.layoutManager=LinearLayoutManager(this)
        rvVerifyInfo.adapter = verifyInfoAdapter
    }

    private fun setServiceProviderAdapter() {
        val serviceProviderAdapter = ServiceProviderAdapter(this,serviceProviderList)
        rvServiceProvider.adapter = serviceProviderAdapter
    }
}