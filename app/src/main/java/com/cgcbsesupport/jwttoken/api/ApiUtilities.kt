package com.cgcbsesupport.jwttoken.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Papaya Coders on 13,November,2022
 */
object ApiUtilities {

    fun getApiInterface(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl("enter base url")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiInterface::class.java)
    }
}