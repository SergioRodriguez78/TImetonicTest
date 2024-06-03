package com.timetonic.test.landing.data.remote

import com.timetonic.test.landing.data.remote.model.LandingResponseDTO
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LandingApi {
    @FormUrlEncoded
    @POST("live/api.php")
    suspend fun getAllBooks(
        @Field("version") version: String,
        @Field("req") req: String,
        @Field("u_c") uc: String,
        @Field("o_u") ou: String,
        @Field("sesskey") sessionKey: String,
    ): LandingResponseDTO
}
