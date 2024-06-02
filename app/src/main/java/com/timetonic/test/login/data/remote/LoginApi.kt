package com.timetonic.test.login.data.remote

import com.timetonic.test.login.data.remote.model.AppKeyCreate
import com.timetonic.test.login.data.remote.model.OAuthKey
import com.timetonic.test.login.data.remote.model.SessionKeyCreate
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {
    @FormUrlEncoded
    @POST("live/api.php")
    suspend fun createAppKey(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("appname") appName: String
    ): AppKeyCreate

    @FormUrlEncoded
    @POST("live/api.php")
    suspend fun createOauthKey(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("login") login: String,
        @Field("pwd") pwd: String,
        @Field("appkey") appkey: String
    ): OAuthKey

    @FormUrlEncoded
    @POST("live/api.php")
    suspend fun createSessionKey(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("o_u") o_u: String,
        @Field("u_c") u_c: String,
        @Field("oauthkey") oauthkey: String
    ): SessionKeyCreate
}
