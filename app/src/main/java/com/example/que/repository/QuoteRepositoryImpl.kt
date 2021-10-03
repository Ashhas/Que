package com.example.que.repository

import androidx.lifecycle.LiveData
import com.example.que.data.QuoteDao
import com.example.que.network.QuoteService
import com.example.que.data.model.Quote

class QuoteRepositoryImpl(private val api: QuoteService, private val quoteDao: QuoteDao) :
    QuoteRepository {

    //Save quote
    override suspend fun insertQuote(newQuote: Quote) {
        quoteDao.insertQuote(newQuote)
    }

    //Get a random quote
    override suspend fun getRandomQuote(): Quote {
        return api.getRandomImage()
    }

    //Get stored quotes
    override fun getStoredQuotes(): LiveData<List<Quote>> {
        return quoteDao.getAllQuotes()
    }
}