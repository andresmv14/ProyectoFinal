package com.fa.proyectofinal

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private lateinit var apiService: APIService
    fun getApiService(context: Context): APIService{
        if (!::apiService.isInitialized){
            val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            apiService = retrofit.create(APIService::class.java)
        }
        return apiService
}
    private fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()
    }
}