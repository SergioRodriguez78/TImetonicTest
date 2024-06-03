package com.timetonic.test.login.data

import com.timetonic.test.network.ApiResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(email: String, password: String): Flow<ApiResponse<Unit?>>
}
