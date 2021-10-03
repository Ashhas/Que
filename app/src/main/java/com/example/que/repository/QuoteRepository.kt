package com.example.que.repository

import androidx.lifecycle.LiveData
import com.example.que.data.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {

    suspend fun insertQuote(newQuote: Quote)

    suspend fun getRandomQuote(): Quote

    fun getStoredQuotes(): LiveData<List<Quote>>

}