package com.example.tokoalatmusik.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tokoalatmusik.Helper.SharedPref
import com.example.tokoalatmusik.R

class LoginActivity : AppCompatActivity() {

    lateinit var share:SharedPref
    lateinit var buttonproses : Button
    lateinit var buttonregister : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        share = SharedPref(this)



    }

    fun mainButton(){
        buttonproses = findViewById(R.id.btn_prosesLogin)
        buttonproses.setOnClickListener {
            share.setStatusLogin(true)
        }
        buttonregister = findViewById(R.id.btn_register)
        buttonregister.setOnClickListener {
            share.setRegister(true)
        }
    }
}
