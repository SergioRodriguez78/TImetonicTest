package com.timetonic.test.landing.data.remote

import com.timetonic.test.landing.data.remote.model.LandingResponseDTO
import kotlinx.coroutines.flow.Flow

interface LandingService {
    suspend fun getAllBooks(
        version: String,
        req: String,
        uc: String,
        ou: String,
        sessionKey: String,
    ): Flow<LandingResponseDTO>
}
