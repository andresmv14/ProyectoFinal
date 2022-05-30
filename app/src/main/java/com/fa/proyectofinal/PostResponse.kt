package com.fa.proyectofinal

import com.google.gson.annotations.SerializedName

data class PostResponse(

    @SerializedName("title")
    var task: Post,

    @SerializedName("id")
    var id: String,

)
