package com.example.tokoalatmusik.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.tokoalatmusik.Helper.SharedPref
import com.example.tokoalatmusik.R
import com.example.tokoalatmusik.activity.LoginActivity


class AkunFragment : Fragment() {

    lateinit var share: SharedPref
    lateinit var btnLogout: TextView
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)
        init(view)
        btnLogout = view.findViewById(R.id.btn_logout)

        share = SharedPref(requireActivity())
        setData()
        mainButton()
        return view
    }

    fun mainButton() {
        btnLogout.setOnClickListener {
            share.setStatusLogin(false)
        }


    }

    fun setData() {
        if (share.getUser() == null) {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            return
        }
        val user = share.getUser()!!

        tvNama.text = user.name
        tvEmail.text = user.email
        tvPhone.text = user.phone

        }




    private fun init(view: View) {
        btnLogout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)

    }

}