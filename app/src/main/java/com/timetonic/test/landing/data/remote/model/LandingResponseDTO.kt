package com.timetonic.test.landing.data.remote.model

import com.google.gson.annotations.SerializedName

data class LandingResponseDTO(
    @SerializedName("status") val status: String,
    @SerializedName("allBooks") val allBooks: BookDTO
)
