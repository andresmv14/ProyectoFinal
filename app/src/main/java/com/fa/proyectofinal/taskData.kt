package com.fa.proyectofinal

import com.google.gson.annotations.SerializedName

data class taskData(@SerializedName("title") val titleT:String,
                    @SerializedName("start_date") val startDate:String,
                    @SerializedName("end_Date") val endDate:String,
                    @SerializedName("time") val time: String,
                    @SerializedName("priority") val priority:Int
)
