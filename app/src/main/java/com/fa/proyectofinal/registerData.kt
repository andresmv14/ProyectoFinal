package com.fa.proyectofinal

import com.google.gson.annotations.SerializedName

data class registerData(@SerializedName("name") val nameR:String,
                        @SerializedName("email") val emailR:String,
                        @SerializedName("password") val paswordR:String,
                        @SerializedName("password_confirmation") val passCR:String)
