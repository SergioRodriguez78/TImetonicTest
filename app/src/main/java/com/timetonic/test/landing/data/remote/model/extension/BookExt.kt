package com.timetonic.test.landing.data.remote.model.extension

import com.timetonic.test.BuildConfig
import com.timetonic.test.landing.data.remote.model.BooksInfoDTO
import com.timetonic.test.landing.ui.model.BookUI


fun BooksInfoDTO.toBookUI(): BookUI {
    return BookUI(
        name = this.details.name,
        coverImage = BuildConfig.MAIN_URL + this.ownerPrefs.coverImg.orEmpty(),
        id = this.id.toString(),
    )
}
