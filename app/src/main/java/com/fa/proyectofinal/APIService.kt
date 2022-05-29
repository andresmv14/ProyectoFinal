package com.fa.proyectofinal



import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface APIService {
    @POST(Constants.LOGIN_URL)

    fun getLogin(@Body request: loginData): retrofit2.Call<loginResponse>
}