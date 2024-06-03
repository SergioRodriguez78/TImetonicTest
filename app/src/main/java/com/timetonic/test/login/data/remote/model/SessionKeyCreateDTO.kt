package com.timetonic.test.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class SessionKeyCreateDTO(
    @SerializedName("status") val status: String,
    @SerializedName("sesskey") val sesskey: String,
    @SerializedName("createdVNB") val createdVNB: String,
    @SerializedName("req") val req: String,
)
