package com.simakmu.simakmu.ui.transaksi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.simakmu.simakmu.data.utils.spreadSheet
import com.simakmu.simakmu.databinding.FragmentTransaksiBinding
import com.simakmu.simakmu.ui.transaksi.adapter.TransaksiAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransaksiFragment : Fragment() {

    private lateinit var binding: FragmentTransaksiBinding
    private lateinit var transaksiAdapter: TransaksiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransaksiBinding.inflate(inflater, container, false)
        setupObserver()
        updateUI()
        return binding.root
    }

    private fun setupObserver() {
        transaksiAdapter = TransaksiAdapter {
            when(it){
                "1" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1xFR6qEiG_B3XTFjIqRFO0FI8o1WpJgTfvL95PrOTIko/edit?usp=sharing"
                    )
                }
                "2" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1N7bJHvsGWKiWwCpeD3Kazlm32awU6SdMszEMkZ8v4Kk/edit?usp=sharing"
                    )
                }
                "3" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1W8_hnBrR5XPCDXoV_ukDsP61SpqZxvezDJtWFdn4FW8/edit?usp=sharing"
                    )
                }
            }
        }
    }

    private fun updateUI() = with(binding) {
        rvTransaksi.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = transaksiAdapter
        }
    }

}