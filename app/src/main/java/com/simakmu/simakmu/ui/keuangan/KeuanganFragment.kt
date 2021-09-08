package com.simakmu.simakmu.ui.keuangan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.simakmu.simakmu.data.utils.spreadSheet
import com.simakmu.simakmu.databinding.FragmentKeuanganBinding
import com.simakmu.simakmu.ui.keuangan.adapter.KeuanganAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KeuanganFragment : Fragment() {

    private lateinit var binding: FragmentKeuanganBinding
    private lateinit var keuanganAdapter: KeuanganAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKeuanganBinding.inflate(inflater, container, false)
        setupObserver()
        updateUI()
        return binding.root
    }

    private fun setupObserver() {
        keuanganAdapter = KeuanganAdapter {
            when (it) {
                "1" -> {
                    requireActivity().spreadSheet("https://docs.google.com/spreadsheets/d/1MpCRw_NAmnZ9aSJQMwNG2lJTWo5W9oNC_16hwDWw-Ro/edit?usp=sharing")
                }
                "2" -> {
                    requireActivity().spreadSheet("https://docs.google.com/spreadsheets/d/1sKha5HnfJ1JnFmV42uFiTgcTVBUt87tgsyGLP_pcssg/edit?usp=sharing")
                }
                "3" -> {
                    requireActivity().spreadSheet("https://docs.google.com/spreadsheets/d/1h0xVa4vY2SCudUXY1AEd7tpfiePlpajYrZFoh7NwfVA/edit?usp=sharing")
                }
                "4" -> {
                    requireActivity().spreadSheet("https://docs.google.com/spreadsheets/d/1uwBv0ckAIG55hWu9UwyRSz4pFth9lJtUuWBPCz3Iqac/edit?usp=sharing")
                }
                "5" -> {
                    requireActivity().spreadSheet("https://docs.google.com/spreadsheets/d/15p9ykLOFvRVU_z-7HCjFthdKb4XXAz9N4alkpBlOtK0/edit?usp=sharing")
                }
            }
        }
    }

    private fun updateUI() = with(binding) {
        rvKeuangan.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = keuanganAdapter
        }
    }


}