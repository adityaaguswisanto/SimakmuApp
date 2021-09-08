package com.simakmu.simakmu.ui.analisa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.simakmu.simakmu.data.utils.spreadSheet
import com.simakmu.simakmu.databinding.FragmentAnalisaBinding
import com.simakmu.simakmu.ui.analisa.adapter.AnalisaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnalisaFragment : Fragment() {

    private lateinit var binding: FragmentAnalisaBinding
    private lateinit var analisaAdapter: AnalisaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnalisaBinding.inflate(inflater, container, false)
        setupObserver()
        updateUI()
        return binding.root
    }

    private fun setupObserver() {
        analisaAdapter = AnalisaAdapter {
            when (it) {
                "1" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1J8tsUAdhOgC7MZZtNVwup7smsQYGGgCKxm9JTKMvDmE/edit?usp=sharing"
                    )
                }
                "2" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1_j1kkbjkmtEeSB5F0bWxbsp2B5J3U4MSs53GMTrVAdo/edit?usp=sharing"
                    )
                }
                "3" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/149VjM7haDq3ThgJZ1_zWF2-XVHp6xGlhant0U-aja-U/edit?usp=sharing"
                    )
                }
            }
        }
    }

    private fun updateUI() = with(binding) {
        rvAnalisa.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = analisaAdapter
        }
    }

}