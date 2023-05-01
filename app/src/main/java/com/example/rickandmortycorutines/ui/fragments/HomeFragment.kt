package com.example.rickandmortycorutines.ui.fragments

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortycorutines.R
import com.example.rickandmortycorutines.base.BaseFragment
import com.example.rickandmortycorutines.databinding.FragmentHomeBinding
import com.example.rickandmortycorutines.ui.adapter.HomeAdapter
import com.example.rickandmortycorutines.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeAdapter()

    override fun initialize() {
        binding.homeRecView.adapter = homeAdapter
    }

    override fun setupSubscribes() {
        subscribeToGetData()
    }

    private fun subscribeToGetData() {
        viewModel.noteLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {}
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    homeAdapter.submitList(it.data)
                }
            }
        }
    }
}
