package com.fa.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class viewTask : Fragment() {


        private lateinit var sessionManager: SessionManager
        private lateinit var apiClient: ApiClient
        lateinit var btnA:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_view_task, container, false)
        // Inflate the layout for this fragment
        viewT()
        btnA = vista.findViewById(R.id.btnAdd)

        btnA.setOnClickListener {
            findNavController().navigate(R.id.addT)
        }
            return vista

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


