package com.example.tokoalatmusik.app
import com.example.tokoalatmusik.model.ResponModel
import retrofit2.Call
import retrofit2.http.*
import okhttp3.ResponseBody

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("password") password: String,
    ): Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponModel>


}