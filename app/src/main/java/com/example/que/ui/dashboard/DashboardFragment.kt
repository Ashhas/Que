package com.example.que.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.que.R
import com.example.que.databinding.DashboardFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {
    private lateinit var binding: DashboardFragmentBinding
    private val dashboardViewModel by viewModel<DashboardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DashboardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Select Starting Layout
        checkInternetConnection()

        //Quote Textview
        dashboardViewModel.randomQuote.observe(viewLifecycleOwner, { randomQuote ->
            binding.tvQuote.text = getString(R.string.quote_format, randomQuote.content)
            binding.tvQuoteAuthor.text = randomQuote.author

            //Save quote in database
            binding.btnSave.setOnClickListener {
                dashboardViewModel.insertQuote(randomQuote)
                Toast.makeText(context, "Saved Quote!", Toast.LENGTH_SHORT).show()
            }

            //Share quote
            binding.btnShare.setOnClickListener {
                dashboardViewModel.shareQuote(randomQuote)
            }
        })

        //Reload quote
        binding.btnReloadQuote.setOnClickListener {
            dashboardViewModel.getRandomQuote()
        }

        //Retry quote request
        binding.btnRetry.setOnClickListener {
            retryQuoteRequest()
        }
    }

    private fun retryQuoteRequest() {
        if (dashboardViewModel.isNetworkAvailable() == true) {
            showDefaultLayout()
            dashboardViewModel.getRandomQuote()
        } else {
            showNoInternetLayout()
            Toast.makeText(context, "Still no connection", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkInternetConnection() {
        if (dashboardViewModel.isNetworkAvailable() == true) {
            showDefaultLayout()
        } else {
            showNoInternetLayout()
        }
    }

    private fun showDefaultLayout() {
        binding.layoutDefault.visibility = VISIBLE
        binding.noInternetLayout.visibility = GONE
    }

    private fun showNoInternetLayout() {
        binding.layoutDefault.visibility = GONE
        binding.noInternetLayout.visibility = VISIBLE
    }
}