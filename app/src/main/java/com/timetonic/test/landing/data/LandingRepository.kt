package com.timetonic.test.landing.data

import com.timetonic.test.landing.ui.model.BookUI
import kotlinx.coroutines.flow.Flow

interface LandingRepository {
    suspend fun getAllBooks(): Flow<List<BookUI>>
}
