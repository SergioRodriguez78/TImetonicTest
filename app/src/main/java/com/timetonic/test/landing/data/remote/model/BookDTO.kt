package com.timetonic.test.landing.data.remote.model

import com.google.gson.annotations.SerializedName

data class BookDTO(
    @SerializedName("contacts") val id: ContactDTO,
    @SerializedName("books") val name: BooksInfoDTO,
)
