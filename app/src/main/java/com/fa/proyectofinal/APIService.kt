package com.fa.proyectofinal

import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {
    @POST
    fun getLogin(@Body login: loginData): Call<loginData>
}