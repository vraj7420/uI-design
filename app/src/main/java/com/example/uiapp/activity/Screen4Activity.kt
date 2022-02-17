package com.example.uiapp.activity

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uiapp.R
import com.example.uiapp.adapter.PaymentAdapter
import com.example.uiapp.model.PaymentModel
import kotlinx.android.synthetic.main.activity_screen4.*

class Screen4Activity : AppCompatActivity() {
    private val  paymentList=ArrayList<PaymentModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen4)
        init()
    }
    private fun init(){
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = "Payment Method"
        for (i in 1..10) {
            paymentList.add(
                PaymentModel("Restaurant-Busser","$42.50","Status:Paid",Uri.parse("android.resource://com.example.uiapp/drawable/ic_next_gray_colour").toString(),"Card ending in 1234","Authorized Mar 4,2019-8:14:53 am",Uri.parse("android.resource://com.example.uiapp/drawable/ic_next_gray_colour").toString(),"Paul","TaskId:578"))
        }
        setPaymentAdapter()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            (android.R.id.home) -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setPaymentAdapter() {
        val paymentAdapter = PaymentAdapter(this,paymentList)
        rvPaymentHistory.layoutManager =LinearLayoutManager(this)
        rvPaymentHistory.adapter = paymentAdapter
    }
}