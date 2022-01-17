package com.example.tokoalatmusik.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.tokoalatmusik.Helper.SharedPref
import com.example.tokoalatmusik.MainActivity
import com.example.tokoalatmusik.R
import com.example.tokoalatmusik.app.ApiConfig
import com.example.tokoalatmusik.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var share:SharedPref
    lateinit var btn_login : Button
    lateinit var pb : ProgressBar
    lateinit var edt_email : TextView
    lateinit var edt_password : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        share = SharedPref(this)
        pb = findViewById(R.id.pb)
        //
        edt_email = findViewById(R.id.edt_email)
        edt_password = findViewById(R.id.edt_password)
        //
        btn_login = findViewById(R.id.btn_login)

        btn_login.setOnClickListener {
            login()
        }
    }

        fun login() {

            if (edt_email.text.isEmpty()) {
                edt_email.error = "Kolom nama tidak boleh kosong"
                edt_email.requestFocus()
                return
            } else if (edt_password.text.isEmpty()) {
                edt_password.error = "Kolom nama tidak boleh kosong"
                edt_password.requestFocus()
                return
            }


    pb.visibility = View.VISIBLE
    ApiConfig.instanceRetrofit.login(edt_email.text.toString(),edt_password.text.toString()).enqueue(object : Callback<ResponModel>{
        override fun onFailure(call: Call<ResponModel>, t: Throwable) {
            pb.visibility = View.GONE

            Toast.makeText(this@LoginActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
        }

        override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
            pb.visibility = View.GONE
            val respon = response.body()!!

            if (respon.success == 1) {
                share.setStatusLogin(true)
                share.setUser(respon.user)
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
                Toast.makeText(this@LoginActivity, "Selamat datang " + respon.user.name, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@LoginActivity, "Error:" + respon.message, Toast.LENGTH_SHORT).show()
            }
        }
    })



}
}
