package com.timetonic.test.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class AppKeyCreate(
    @SerializedName("status") val status: String,
    @SerializedName("appkey") val appKey: String,
    @SerializedName("createdVNB") val createdVNB: String,
    @SerializedName("req") val req: String,
)
