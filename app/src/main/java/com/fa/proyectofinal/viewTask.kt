package com.fa.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class viewTask : Fragment() {


        private lateinit var sessionManager: SessionManager
        private lateinit var apiClient: ApiClient
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewT()
        return inflater.inflate(R.layout.fragment_view_task, container, false)

        }
    fun viewT(){
        apiClient = ApiClient()
        sessionManager = SessionManager(requireContext())





        apiClient.getApiService(requireContext()).fetchPost().enqueue(object : Callback<PostResponse>{
            override fun onResponse(
                call: Call<PostResponse>,
                t: Response<PostResponse>
            ) {
                val PostResponse = t.body()

                if (PostResponse != null) {
                    Log.e("Conection api",PostResponse.toString())
                }
            }

            override fun onFailure(call: Call<PostResponse>, response: Throwable) {

            }

        })
    }

    }


