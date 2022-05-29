package com.fa.proyectofinal

import com.google.gson.annotations.SerializedName

data class loginData(@SerializedName("email") val email:String, @SerializedName("password") val password:String)
