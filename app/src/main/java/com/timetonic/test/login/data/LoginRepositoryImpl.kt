package com.timetonic.test.login.data

import com.timetonic.test.dataAccess.sharedPreferences.manager.SharedPreferencesManager
import com.timetonic.test.dataAccess.sharedPreferences.manager.SharedPreferencesManagerImpl
import com.timetonic.test.login.data.remote.LoginService
import com.timetonic.test.network.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

@OptIn(ExperimentalCoroutinesApi::class)
class LoginRepositoryImpl(
    private val loginService: LoginService,
    private val preferences: SharedPreferencesManager
) : LoginRepository {

    override suspend fun login(email: String, password: String): Flow<ApiResponse<Unit?>> =
        withContext(Dispatchers.IO) {
            loginService.createAppKey().flatMapConcat { appKey ->
                loginService.createOAuthKey(
                    userId = email,
                    pwd = password,
                    appKey = appKey.appKey
                )
            }.flatMapConcat { oauthKey ->

                preferences.writeString(SharedPreferencesManagerImpl.OU, oauthKey.ou)

                loginService.createSessionKey(
                    ou = oauthKey.ou,
                    oauthKey = oauthKey.oauthkey
                ).map { sessionKey ->
                    if (sessionKey.sesskey.isBlank()) {
                        ApiResponse.Error(Throwable("Session key is blank"))
                    } else {
                        preferences.writeString(
                            SharedPreferencesManagerImpl.SESSION_KEY,
                            sessionKey.sesskey
                        )
                        ApiResponse.Success(Unit)
                    }
                }
            }
        }
}
