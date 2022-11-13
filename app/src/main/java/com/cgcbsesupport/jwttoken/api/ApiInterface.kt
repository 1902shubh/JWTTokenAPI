package com.cgcbsesupport.jwttoken.api

import com.cgcbsesupport.jwttoken.model.MandirModel
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 * Created by Papaya Coders on 13,November,2022
 */
interface ApiInterface {

    @Multipart
    @POST("/api/v1/api-v2.php")
    suspend fun getMandir(
        @Part("para2") para2: RequestBody,
        @Part("para1") para1: RequestBody,
        @Header("Authorization") authHeader: String
    ): Response<MandirModel>
}