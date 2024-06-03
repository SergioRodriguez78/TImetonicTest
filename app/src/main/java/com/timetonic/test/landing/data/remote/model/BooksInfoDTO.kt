package com.timetonic.test.landing.data.remote.model

import com.google.gson.annotations.SerializedName

data class BooksInfoDTO(
    @SerializedName("sstamp") val id: Long,
    @SerializedName("fpForm") val details: BookDetailsDTO,
    @SerializedName("ownerPrefs") val ownerPrefs: OwnerPrefsDTO,
)
