package com.example.que.repository

import androidx.lifecycle.LiveData
import com.example.que.data.model.Quote

interface QuoteRepository {

    suspend fun insertQuote(newQuote: Quote)

    suspend fun getRandomQuote(): Quote

    suspend fun deleteAllQuotes()

    fun getStoredQuotes(): LiveData<List<Quote>>

}