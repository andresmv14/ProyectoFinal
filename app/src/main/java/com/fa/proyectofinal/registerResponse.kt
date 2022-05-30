package com.fa.proyectofinal

import com.google.gson.annotations.SerializedName

data class registerResponse(@SerializedName("id") val id:Int, @SerializedName("token") val token:String)
