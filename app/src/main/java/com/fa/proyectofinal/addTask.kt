package com.fa.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class addTask : Fragment() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    lateinit var titleA: TextView
    lateinit var sDate: TextView
    lateinit var eDate: TextView
    lateinit var timeA: TextView
    lateinit var prior:TextView
    lateinit var btnAdd: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vista =inflater.inflate(R.layout.fragment_add_task, container, false)
        titleA= vista.findViewById(R.id.titleA)
        sDate= vista.findViewById(R.id.sDate)
        eDate= vista.findViewById(R.id.eDate)
        timeA= vista.findViewById(R.id.timeA)
        prior= vista.findViewById(R.id.priorityA)
        btnAdd= vista.findViewById(R.id.Add)

        btnAdd.setOnClickListener {
            getTask()
        }
        return vista
    }

    fun getTask(){
        apiClient = ApiClient()
        sessionManager = SessionManager(requireContext())
        apiClient.getApiService(requireContext()).getTask(taskData(titleA.text.toString(), sDate.text.toString(),
            eDate.text.toString(),timeA.text.toString(),prior.text.toString().toInt())).enqueue(object :
            Callback<taskResponse> {
            override fun onResponse(
                call: Call<taskResponse>,
                t: Response<taskResponse>
            ) {
                val taskResponse = t.body()
                if (taskResponse?.nameTi !="" && taskResponse != null) {
                    Log.e("Conection api",taskResponse.nameTi)

                    findNavController().navigate(R.id.viewAd)
                } else {
                    Log.e("Error api","errooooooor")
                }

            }

            override fun onFailure(call: Call<taskResponse>, t: Throwable) {

            }


        })
    }


}