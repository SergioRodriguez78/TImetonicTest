package com.timetonic.test.landing.data.remote.model

import com.google.gson.annotations.SerializedName

data class OwnerPrefsDTO(
    @SerializedName("oCoverImg") val coverImg: String?,
)
