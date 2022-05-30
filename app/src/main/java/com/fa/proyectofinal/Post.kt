package com.fa.proyectofinal

import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("title")
    var title: String,

    @SerializedName("time")
    var time: String,

)
