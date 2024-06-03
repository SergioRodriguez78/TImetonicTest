package com.timetonic.test.landing.data.remote

import com.timetonic.test.landing.data.remote.model.LandingResponseDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LandingServiceImpl(
    private val api: LandingApi
) : LandingService {

    override fun getAllBooks(
        uc: String,
        ou: String,
        sessionKey: String
    ): Flow<LandingResponseDTO> = flow {
        emit(
            api.getAllBooks(
                version = APP_VERSION,
                req = APP_KEY_REQ,
                uc = uc,
                ou = ou,
                sessionKey = sessionKey
            )
        )
    }

    companion object {
        const val APP_VERSION = "6.49q/6.49"
        const val APP_KEY_REQ = "getAllBooks"
    }
}
