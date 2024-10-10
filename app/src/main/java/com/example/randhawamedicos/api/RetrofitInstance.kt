package com.example.randhawamedicos.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    val api: API_Builder = Retrofit.Builder()
        .client(client)
        .baseUrl(API_Builder.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client).build().create(API_Builder::class.java)
}