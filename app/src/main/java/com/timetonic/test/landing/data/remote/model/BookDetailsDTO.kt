package com.timetonic.test.landing.data.remote.model

import com.google.gson.annotations.SerializedName

data class BookDetailsDTO(
    @SerializedName("name") val name: String,
)
