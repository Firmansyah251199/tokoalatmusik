package com.example.tokoalatmusik.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.tokoalatmusik.Helper.SharedPref
import com.example.tokoalatmusik.R


class AkunFragment : Fragment() {

    lateinit var share :SharedPref
    lateinit var btnLogout:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)
        btnLogout = view.findViewById(R.id.btn_logout)

        share = SharedPref(requireActivity())

        btnLogout.setOnClickListener{
            share.setStatusLogin(false)
        }
        return view
    }
}