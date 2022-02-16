package com.example.uiapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.uiapp.R
import kotlinx.android.synthetic.main.activity_screen3.*

class Screen3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3)
        init()
        setListener()
    }

    private fun init() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setTitle(R.string.back)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    @SuppressLint("ResourceAsColor")
    private fun setListener() {
        rbFlatFree.setOnClickListener {
            if (rbHourly.isChecked) {
                rbHourly.isChecked = false
                tvHourly.setTextColor(ContextCompat.getColor(this, R.color.gray_808080))
                tvFlatFree.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }
        rbHourly.setOnClickListener {
            if (rbFlatFree.isChecked) {
                rbFlatFree.isChecked = false
                tvHourly.setTextColor(ContextCompat.getColor(this, R.color.black))
                tvFlatFree.setTextColor(ContextCompat.getColor(this, R.color.gray_808080))
            }
        }
        btnNext.setOnClickListener {
            val intentScreen4 = Intent(this, Screen4Activity::class.java)
            startActivity(intentScreen4)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_application, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            (android.R.id.home) -> {
                this.finish()
            }
            (R.id.close) -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}