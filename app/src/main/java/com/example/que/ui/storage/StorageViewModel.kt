package com.example.que.ui.storage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.que.data.model.Quote
import com.example.que.repository.QuoteRepositoryImpl

class StorageViewModel(private val quoteRepo: QuoteRepositoryImpl) : ViewModel() {
    val allQuotesList: LiveData<List<Quote>>
        get() = getAllQuotes()


    private fun getAllQuotes(): LiveData<List<Quote>> {
        return quoteRepo.getStoredQuotes()
    }
}