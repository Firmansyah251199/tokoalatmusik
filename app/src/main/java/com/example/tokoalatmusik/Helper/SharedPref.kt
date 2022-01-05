package com.example.tokoalatmusik.Helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref(activity: Activity) {
    val login = "login"
    val register = "register"
    val mypref = "MAIN_PRF"
    val sp : SharedPreferences

    init{
            sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
        }

    fun setStatusLogin(status:Boolean){
        sp.edit().putBoolean(login,status).apply()
    }
    fun setRegister(status:Boolean){
        sp.edit().putBoolean(register,status).apply()
    }

    fun getRegister():Boolean{
        return sp.getBoolean(register, false)
    }

    fun getStatusLogin():Boolean{
        return sp.getBoolean(register, false)
    }
}