package com.example.que.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.que.data.model.Quote
import com.example.que.repository.QuoteRepositoryImpl
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val quoteRepo: QuoteRepositoryImpl
) : ViewModel() {

    private val _randomQuote = MutableLiveData<Quote>()
    val randomQuote: LiveData<Quote> get() = _randomQuote

    init {
        getRandomQuote()
    }

    fun insertQuote(newQuote: Quote) {
        viewModelScope.launch {
            quoteRepo.insertQuote(newQuote)
        }
    }

    fun getRandomQuote() {
        viewModelScope.launch {
            Log.d("DashboardViewModel", quoteRepo.getRandomQuote().toString())
            _randomQuote.value = quoteRepo.getRandomQuote()
        }
    }
}