package com.fa.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class login : Fragment() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    lateinit var email:EditText
    lateinit var password: EditText
    lateinit var btnlogin: Button
    lateinit var btnRegister: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
            email = view.findViewById(R.id.email)
            password = view.findViewById(R.id.pass)
            btnlogin = view.findViewById(R.id.btnLogin)
            btnRegister = view.findViewById(R.id.btnRegister)

            btnRegister.setOnClickListener{
                findNavController().navigate(R.id.registerFragment)
            }
            btnlogin.setOnClickListener{
            Api()

                
       }
        // Inflate the layout for this fragment
        return view
    }

    fun Api(){

        apiClient = ApiClient()
        sessionManager = SessionManager(requireContext())
        apiClient.getApiService(requireContext()).getLogin(loginData(email.text.toString(),password.text.toString() )).enqueue(object : Callback<loginResponse>{
            override fun onResponse(
                call: Call<loginResponse>,
                t: Response<loginResponse>
            ) {
                val loginResponse = t.body()
                if (loginResponse?.status == 1 && loginResponse.user != null) {
                    Log.e("Conection api",loginResponse.user.token)
                    sessionManager.saveAuthToken(loginResponse.user.token)
                    findNavController().navigate(R.id.task)
                } else {
                    Log.e("Error api","errooooooor")
                }

            }

            override fun onFailure(call: Call<loginResponse>, t: Throwable) {

            }

        })
    }



}