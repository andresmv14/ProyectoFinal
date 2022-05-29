package com.fa.proyectofinal

import com.google.gson.annotations.SerializedName

data class loginResponse(@SerializedName("status") val status: Int, @SerializedName("msg") val msg: String, @SerializedName("user") val user:User)
