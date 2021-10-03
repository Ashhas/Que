package com.example.que.ui.dashboard

import android.os.Bundle
import android.view.*
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

        //Quote Textview
        dashboardViewModel.randomQuote.observe(viewLifecycleOwner, { randomQuote ->
            binding.tvQuote.text = getString(R.string.quote_format, randomQuote.content)
            binding.tvQuoteAuthor.text = randomQuote.author

            //Reload quote
            binding.iBtnReloadQuote.setOnClickListener {
                dashboardViewModel.getRandomQuote()
            }

            //Save quote in database
            binding.btnSave.setOnClickListener {
                dashboardViewModel.insertQuote(randomQuote)
                Toast.makeText(context, "Saved Quote!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}