package com.example.tokoalatmusik.activity

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tokoalatmusik.Helper.SharedPref
import com.example.tokoalatmusik.R
import com.example.tokoalatmusik.app.ApiConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    lateinit var share: SharedPref
    lateinit var buttonregister: Button
    lateinit var edt_nama: EditText
    lateinit var edt_email: EditText
    lateinit var edt_phone: EditText
    lateinit var edt_password: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //
        edt_nama = findViewById(R.id.edt_nama)
        edt_email = findViewById(R.id.edt_email)
        edt_phone = findViewById(R.id.edt_phone)
        edt_password = findViewById(R.id.edt_password)
        //
        buttonregister = findViewById(R.id.btn_register)
        buttonregister.setOnClickListener { share.setRegister(true) }

        share = SharedPref(this)

        register()
    }

    fun register() {
        if (edt_nama.text.isEmpty()){
            edt_nama.error = "Kolom nama tidak boleh kosong"
            edt_nama.requestFocus()
            return
        }
        else if (edt_email.text.isEmpty()){
            edt_email.error = "Kolom nama tidak boleh kosong"
            edt_email.requestFocus()
            return
        }
        else if (edt_phone.text.isEmpty()){
            edt_phone.error = "Kolom nama tidak boleh kosong"
            edt_phone.requestFocus()
            return
        }
        else if (edt_password.text.isEmpty()){
            edt_password.error = "Kolom nama tidak boleh kosong"
            edt_password.requestFocus()
            return
        }
        ApiConfig.instanceRetrofit.register(edt_nama.text.toString(), edt_email.text.toString(),edt_email.text.toString()).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
              //ketika gagal
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
               // ketika sukses
            }

        })

    }
}
