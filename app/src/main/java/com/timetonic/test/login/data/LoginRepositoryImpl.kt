package com.timetonic.test.login.data

import com.timetonic.test.login.data.remote.LoginService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

@OptIn(ExperimentalCoroutinesApi::class)
class LoginRepositoryImpl(
    private val loginService: LoginService
) : LoginRepository {

    override suspend fun login(email: String, password: String): Flow<String> = flow {
        withContext(Dispatchers.IO) {
            loginService.createAppKey().flatMapConcat { appKey ->
                loginService.createOAuthKey(
                    userId = email,
                    pwd = password,
                    appKey = appKey.appKey
                )
            }.flatMapConcat { oauthKey ->
                loginService.createSessionKey(
                    ou = email,
                    oauthKey = oauthKey.ou
                ).map {
                    emit(it.sesskey)
                }
            }
        }
    }
}
