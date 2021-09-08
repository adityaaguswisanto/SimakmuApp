package com.simakmu.simakmu.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.simakmu.simakmu.data.utils.spreadSheet
import com.simakmu.simakmu.databinding.FragmentHomeBinding
import com.simakmu.simakmu.ui.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setupObserver()
        updateUI()
        return binding.root
    }

    private fun setupObserver() {
        homeAdapter = HomeAdapter {
            when (it) {
                "1" -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSetupFragment())
                }
                "2" -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToKeuanganFragment())
                }
                "3" -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToIuranFragment())
                }
                "4" -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTransaksiFragment())
                }
                "5" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1aOIVeqEBVNKkmz9yBr-mzJaQ37LNBEVd1zcPHJnfdz4/edit?usp=sharing"
                    )
                }
                "6" -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAnalisaFragment())
                }
            }
        }
    }

    private fun updateUI() = with(binding) {
        rvHome.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = homeAdapter
        }
    }

}