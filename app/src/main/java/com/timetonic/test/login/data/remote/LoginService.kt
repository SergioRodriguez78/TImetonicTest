package com.timetonic.test.login.data.remote

import com.timetonic.test.login.data.remote.model.AppKeyCreate
import com.timetonic.test.login.data.remote.model.OAuthKey
import com.timetonic.test.login.data.remote.model.SessionKeyCreate

interface LoginService {
    suspend fun createAppKey(): AppKeyCreate

    suspend fun createOAuthKey(userId: String, pwd: String, appKey: String): OAuthKey

    suspend fun createSessionKey(ou: String, oauthKey: String): SessionKeyCreate
}
