package com.example.que.repository

import com.example.que.data.model.Quote

interface QuoteRepository {
    suspend fun getRandomQuote(): Quote

}