package com.example.hwahae.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("products")
    fun getCosmetics(
        @Query("skin_type") skin_type: String = "oily",
        @Query("page") page: Int = 1
    ): Call<CosmeticsList>

    @GET("products")
    fun getCosmetics(
        @Query("skin_type") skin_type: String = "oily",
        @Query("page") page: Int = 1,
        @Query("search") search: String
    ): Call<CosmeticsList>

    @GET("products/{id}")
    fun getCosmeticsDetail(
        @Path("id") id: String
    ): Call<CosmeticsDetailList>

}