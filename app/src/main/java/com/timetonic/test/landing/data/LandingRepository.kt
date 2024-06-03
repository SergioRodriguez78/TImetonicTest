package com.timetonic.test.landing.data

import com.timetonic.test.landing.ui.model.BookUI
import com.timetonic.test.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface LandingRepository {
    suspend fun getAllBooks(): Flow<ApiResponse<List<BookUI>?>>
}
