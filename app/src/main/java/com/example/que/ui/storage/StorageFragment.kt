package com.example.que.ui.storage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.que.R
import com.example.que.databinding.StorageFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StorageFragment : Fragment() {

    private val storageViewModel by viewModel<StorageViewModel>()
    private lateinit var binding: StorageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StorageFragmentBinding.inflate(inflater, container, false)
        makeAppBarInvisible()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()

        makeAppBarVisible()
    }

    private fun makeAppBarVisible() {
        val toolBar =
            requireActivity().findViewById<androidx.appcompat.widget.Toolbar>(R.id.mainToolbar)
        val item = toolBar.menu.findItem(R.id.storageFragment)
        item.isVisible = true
    }

    private fun makeAppBarInvisible() {
        val toolBar =
            requireActivity().findViewById<androidx.appcompat.widget.Toolbar>(R.id.mainToolbar)
        val item = toolBar.menu.findItem(R.id.storageFragment)
        item.isVisible = false
    }

}