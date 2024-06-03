package com.timetonic.test.landing.data.remote.model

import com.google.gson.annotations.SerializedName

data class ContactDTO(
    @SerializedName("u_c") val uc: String,
)
