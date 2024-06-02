package com.timetonic.test.login.data.remote

import com.timetonic.test.login.data.remote.model.AppKeyCreate
import com.timetonic.test.login.data.remote.model.OAuthKey
import com.timetonic.test.login.data.remote.model.SessionKeyCreate

class LoginServiceImpl(private val api: LoginApi) : LoginService {

    override suspend fun createAppKey(): AppKeyCreate {
        return api.createAppKey(
            version = APP_VERSION,
            req = APP_KEY_REQ,
            appName = "TimeTonic"
        )
    }

    override suspend fun createOAuthKey(userId: String, pwd: String, appKey: String): OAuthKey {
        return api.createOauthKey(
            version = APP_VERSION,
            req = OAUTH_KEY_REQ,
            login = userId,
            pwd = pwd,
            appkey = appKey
        )
    }

    override suspend fun createSessionKey(ou: String, oauthKey: String): SessionKeyCreate {
        return api.createSessionKey(
            version = APP_VERSION,
            req = SESSION_KEY_REQ,
            o_u = ou,
            u_c = ou,
            oauthkey = oauthKey
        )
    }

    companion object {
        const val APP_VERSION = "6.49q/6.49"
        const val APP_KEY_REQ = "createAppkey"
        const val OAUTH_KEY_REQ = "createOauthkey"
        const val SESSION_KEY_REQ = "createSesskey"
    }
}
