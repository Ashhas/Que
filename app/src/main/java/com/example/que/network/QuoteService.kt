package com.example.que.network

import com.example.que.data.model.Quote
import retrofit2.http.GET

interface QuoteService {

    @GET("/random")
    suspend fun getRandomImage() : Quote
}