package com.example.tokoalatmusik.app
import retrofit2.Call
import retrofit2.http.*
import okhttp3.ResponseBody

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponseBody>


}