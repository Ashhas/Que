package com.example.que.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.que.R
import com.example.que.databinding.ActivityMainBinding
import com.example.que.ui.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class QueActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dashboardViewModel by viewModel<DashboardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Quote textview
        dashboardViewModel.randomQuote.observe(this, { newQuote ->
            binding.tvQuote.text = getString(R.string.quote_format, newQuote.content)
        })

    }
}