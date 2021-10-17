package com.example.que.ui.dashboard

import android.app.Application
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.que.data.model.Quote
import com.example.que.repository.QuoteRepositoryImpl
import kotlinx.coroutines.launch
import java.lang.Exception

class DashboardViewModel(
        private val quoteRepo: QuoteRepositoryImpl,
        private val appContext: Application
) : ViewModel() {

    private var _randomQuote = MutableLiveData<Quote>()
    val randomQuote: LiveData<Quote> get() = _randomQuote

    //Log TAG
    val TAG = "DashboardViewModel"

    init {
        if (isNetworkAvailable() == true) {
            getRandomQuote()
        }
    }

    fun getRandomQuote() {
        if (isNetworkAvailable() == true) {
            viewModelScope.launch {
                Log.d(TAG, quoteRepo.getRandomQuote().toString())
                try {
                    _randomQuote.value = quoteRepo.getRandomQuote()
                } catch (exception: Exception) {
                    Log.e(TAG, exception.message.toString())
                }
            }
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

    fun isNetworkAvailable(): Boolean? {
        val cm = appContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = cm.activeNetwork
            val capabilities = cm.getNetworkCapabilities(activeNetwork)
            capabilities?.hasCapability(NET_CAPABILITY_INTERNET)
        } else {
            cm.activeNetworkInfo?.isConnected
        }
    }
}