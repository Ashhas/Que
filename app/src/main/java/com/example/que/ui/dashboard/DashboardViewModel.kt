package com.example.que.ui.dashboard

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.que.data.model.Quote
import com.example.que.repository.QuoteRepositoryImpl
import kotlinx.coroutines.launch

class DashboardViewModel(
        private val quoteRepo: QuoteRepositoryImpl,
        private val appContext: Application
) : ViewModel() {

    private val _randomQuote = MutableLiveData<Quote>()
    val randomQuote: LiveData<Quote> get() = _randomQuote

    init {
        getRandomQuote()
    }

    fun getRandomQuote() {
        viewModelScope.launch {
            Log.d("DashboardViewModel", quoteRepo.getRandomQuote().toString())
            _randomQuote.value = quoteRepo.getRandomQuote()
        }
    }

    fun insertQuote(newQuote: Quote) {
        viewModelScope.launch {
            quoteRepo.insertQuote(newQuote)
        }
    }

    fun shareQuote(quote: Quote) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "\"${quote.content}\"\n - ${quote.author}")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        appContext.startActivity(shareIntent)
    }
}