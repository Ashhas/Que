package com.example.que.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.que.repository.QuoteRepositoryImpl
import kotlinx.coroutines.launch

class QueViewModel(private val quoteRepo: QuoteRepositoryImpl) : ViewModel() {

    fun deleteAllQuotes() {
        viewModelScope.launch {
            quoteRepo.deleteAllQuotes()
        }
    }

}