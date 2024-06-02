package com.timetonic.test.login.data.remote

import com.timetonic.test.login.data.remote.model.AppKeyCreate
import com.timetonic.test.login.data.remote.model.OAuthKey
import com.timetonic.test.login.data.remote.model.SessionKeyCreate
import kotlinx.coroutines.flow.Flow

interface LoginService {
    fun createAppKey(): Flow<AppKeyCreate>

    fun createOAuthKey(userId: String, pwd: String, appKey: String): Flow<OAuthKey>

    fun createSessionKey(ou: String, oauthKey: String): Flow<SessionKeyCreate>
}
