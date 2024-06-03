package com.timetonic.test.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class OAuthKeyDTO(
    @SerializedName("status") val status: String,
    @SerializedName("oauthkey") val oauthkey: String,
    @SerializedName("o_u") val ou: String,
    @SerializedName("createdVNB") val createdVNB: String,
    @SerializedName("req") val req: String,
)
