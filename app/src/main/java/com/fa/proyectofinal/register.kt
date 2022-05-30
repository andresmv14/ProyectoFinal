package com.fa.proyectofinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class register : Fragment() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    lateinit var name1:TextView
    lateinit var email1:TextView
    lateinit var pass1:TextView
    lateinit var pass2:TextView
    lateinit var btnReg:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_register, container, false)
        name1= vista.findViewById(R.id.tvName)
        email1 = vista.findViewById(R.id.tvEmail)
        pass1 = vista.findViewById(R.id.tvPass)
        pass2 = vista.findViewById(R.id.tvPass2)
        btnReg = vista.findViewById(R.id.btnRegister2)

        btnReg.setOnClickListener {
            if(pass1.text.toString()==pass2.text.toString()){
                reg()
            }else{
                Toast.makeText(requireContext(),"Las Contraseñas no coninciden",Toast.LENGTH_LONG)
            }
        }
        // Inflate the layout for this fragment
        return vista
    }
    fun reg(){
        apiClient = ApiClient()
        sessionManager = SessionManager(requireContext())
        apiClient.getApiService(requireContext()).getRegister(registerData(name1.text.toString(), email1.text.toString(),
        pass1.text.toString(),pass2.text.toString())).enqueue(object :
            Callback<registerResponse> {
            override fun onResponse(
                call: Call<registerResponse>,
                t: Response<registerResponse>
            ) {
                val registerResponse = t.body()
                if (registerResponse?.id !=0 && registerResponse != null) {
                    Log.e("Conection api",registerResponse.id.toString())

                    findNavController().navigate(R.id.regSu)
                } else {
                    Log.e("Error api","errooooooor")
                }

            }



            override fun onFailure(call: Call<registerResponse>, t: Throwable) {

            }

        })

    }


}