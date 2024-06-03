package com.timetonic.test.landing.data.remote

import com.timetonic.test.landing.data.remote.model.LandingResponseDTO
import kotlinx.coroutines.flow.Flow

interface LandingService {
    fun getAllBooks(
        uc: String,
        ou: String,
        sessionKey: String,
    ): Flow<LandingResponseDTO>
}
