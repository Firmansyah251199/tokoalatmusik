package com.example.tokoalatmusik.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tokoalatmusik.Helper.SharedPref
import com.example.tokoalatmusik.R

class MasukActivity : AppCompatActivity() {

        lateinit var share: SharedPref

        lateinit var buttonproses : Button
        lateinit var buttonregister : Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_masuk)

            buttonproses = findViewById(R.id.btn_prosesLogin)
            buttonregister = findViewById(R.id.btn_register)

            share = SharedPref(this)
            buttonproses.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            mainButton()


        }

        private fun mainButton(){


        buttonregister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }


    }

