package com.fa.proyectofinal



import android.telecom.Call
import retrofit2.http.*


interface APIService {
    @POST(Constants.LOGIN_URL)

    fun getLogin(@Body request: loginData): retrofit2.Call<loginResponse>

    @GET(Constants.POSTS_URL)
    fun fetchPost(): retrofit2.Call<PostResponse>

    @POST(Constants.REG_URL)
    fun getRegister(@Body res:registerData): retrofit2.Call<registerResponse>
}