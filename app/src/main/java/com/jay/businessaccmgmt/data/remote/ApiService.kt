package com.jay.businessaccmgmt.data.remote

import retrofit2.http.GET

interface ApiService {

    //https://dummyjson.com/products
    @GET("products")
    suspend fun getProducts(): ApiResponse

}