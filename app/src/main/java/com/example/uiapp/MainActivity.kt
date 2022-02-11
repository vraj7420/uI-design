package com.example.uiapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun setListener() {
        btnCreateAccount.setOnClickListener {
            val intentScreen2 = Intent(this, Screen2Activity::class.java)
            startActivity(intentScreen2)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_application,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            (R.id.home) -> {
                this.finish()
                }
            (R.id.close)->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        val actionBar: ActionBar? = supportActionBar
         actionBar?.setTitle(R.string.title_main_activity)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        tetFirstLast.addTextChangedListener {
            validateData()

        }
        tetEmail.addTextChangedListener {
            validateData()

        }
        tetPassword.addTextChangedListener {
            validateData()
        }
    }

    private fun validateData() {
        if ((tetFirstLast.text.toString().trim().isNotEmpty()) && (tetEmail.text.toString().trim()
                .matches(emailPattern.toRegex())) && (tetPassword.text.toString().isNotEmpty())
        ) {
            btnCreateAccount.setBackgroundResource(R.drawable.round_button_with_purple_color)
            btnCreateAccount.isClickable = true
            setListener()
        }
    }
}