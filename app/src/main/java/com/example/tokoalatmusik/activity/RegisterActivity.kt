package com.example.tokoalatmusik.activity


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tokoalatmusik.Helper.SharedPref
import com.example.tokoalatmusik.MainActivity
import com.example.tokoalatmusik.R
import com.example.tokoalatmusik.app.ApiConfig
import com.example.tokoalatmusik.model.ResponModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    lateinit var share: SharedPref
    lateinit var buttonregister: Button
    lateinit var pb: ProgressBar
    lateinit var btn_google: TextView
    lateinit var edt_nama: EditText
    lateinit var edt_email: EditText
    lateinit var edt_phone: EditText
    lateinit var edt_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        buttonregister = findViewById(R.id.btn_prosesRegister)
        pb = findViewById(R.id.pb)
        btn_google = findViewById(R.id.btn_google)
        //
        edt_nama = findViewById(R.id.edt_nama)
        edt_email = findViewById(R.id.edt_email)
        edt_phone = findViewById(R.id.edt_phone)
        edt_password = findViewById(R.id.edt_password)
        //


        share = SharedPref(this)

        buttonregister.setOnClickListener {
            register()

            }
        btn_google.setOnClickListener {
            dataDummy()
        }
    }

    fun dataDummy() {
        edt_nama.setText("admin")
        edt_email.setText("admin@gmail.com")
        edt_phone.setText("12345678")
        edt_password.setText("admin123")
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


            pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.register(edt_nama.text.toString(), edt_email.text.toString(),edt_phone.text.toString(), edt_password.text.toString()).enqueue(object : Callback<ResponModel>{
                override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                    pb.visibility = View.GONE

                    Toast.makeText(this@RegisterActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                    pb.visibility = View.GONE
                    val respon = response.body()!!

                    if (respon.success == 1) {
                        share.setStatusLogin(true)
                        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                        Toast.makeText(this@RegisterActivity, "Selamat datang " + respon.user.name, Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@RegisterActivity, "Error:" + respon.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })




        }
}
