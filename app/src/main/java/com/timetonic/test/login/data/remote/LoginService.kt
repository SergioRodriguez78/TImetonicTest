package com.timetonic.test.login.data.remote

import com.timetonic.test.login.data.remote.model.AppKeyCreateDTO
import com.timetonic.test.login.data.remote.model.OAuthKeyDTO
import com.timetonic.test.login.data.remote.model.SessionKeyCreateDTO
import kotlinx.coroutines.flow.Flow

interface LoginService {
    fun createAppKey(): Flow<AppKeyCreateDTO>

    fun createOAuthKey(userId: String, pwd: String, appKey: String): Flow<OAuthKeyDTO>

    fun createSessionKey(ou: String, oauthKey: String): Flow<SessionKeyCreateDTO>
}
