package com.example.que.ui.dashboard

import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.que.R
import com.example.que.databinding.ActivityMainBinding
import com.example.que.databinding.FragmentDashboardBinding
import com.example.que.ui.QueActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private val dashboardViewModel by viewModel<DashboardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Quote Textview
        dashboardViewModel.randomQuote.observe(viewLifecycleOwner, { randomQuote ->
            binding.tvQuote.text = getString(R.string.quote_format, randomQuote.content)
        })

        //Navigation Button
        binding.btnNavigate.setOnClickListener {
        }
    }


}