package com.example.que.repository

import com.example.que.data.QuoteService
import com.example.que.data.model.Quote

class QuoteRepositoryImpl(private val api: QuoteService) : QuoteRepository{
    //Get Random Quote
    override suspend fun getRandomQuote(): Quote {
        return api.getRandomImage()
    }

}