package com.example.hwahae.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SearchRetrofit {

    fun getService(): RetrofitService = retrofit.create(RetrofitService::class.java)

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://6uqljnm1pb.execute-api.ap-northeast-2.amazonaws.com/prod/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}