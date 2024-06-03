package com.timetonic.test.landing.data.remote

import com.timetonic.test.landing.data.remote.model.LandingResponseDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LandingServiceImpl(
    private val api: LandingApi
) : LandingService {

    override suspend fun getAllBooks(
        version: String,
        req: String,
        uc: String,
        ou: String,
        sessionKey: String
    ): Flow<LandingResponseDTO> = flow {
        emit(
            api.getAllBooks(
                version = version,
                req = req,
                uc = uc,
                ou = ou,
                sessionKey = sessionKey
            )
        )
    }
}
