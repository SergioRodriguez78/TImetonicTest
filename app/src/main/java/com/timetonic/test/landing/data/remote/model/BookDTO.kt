package com.timetonic.test.landing.data.remote.model

import com.google.gson.annotations.SerializedName

data class BookDTO(
    @SerializedName("contacts") val contacts: List<ContactDTO>,
    @SerializedName("books") val booksInfo: List<BooksInfoDTO>,
)
