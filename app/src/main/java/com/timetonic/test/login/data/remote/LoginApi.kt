package com.timetonic.test.login.data.remote

import com.timetonic.test.login.data.remote.model.AppKeyCreateDTO
import com.timetonic.test.login.data.remote.model.OAuthKeyDTO
import com.timetonic.test.login.data.remote.model.SessionKeyCreateDTO
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
    ): AppKeyCreateDTO

    @FormUrlEncoded
    @POST("live/api.php")
    suspend fun createOauthKey(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("login") login: String,
        @Field("pwd") pwd: String,
        @Field("appkey") appkey: String
    ): OAuthKeyDTO

    @FormUrlEncoded
    @POST("live/api.php")
    suspend fun createSessionKey(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("o_u") o_u: String,
        @Field("u_c") u_c: String,
        @Field("oauthkey") oauthkey: String
    ): SessionKeyCreateDTO
}
