package com.simakmu.simakmu.ui.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.simakmu.simakmu.data.utils.spreadSheet
import com.simakmu.simakmu.databinding.FragmentSetupBinding
import com.simakmu.simakmu.ui.setup.adapter.SetupAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SetupFragment : Fragment() {

    private lateinit var binding: FragmentSetupBinding
    private lateinit var setupAdapter: SetupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSetupBinding.inflate(inflater, container, false)
        setupObserver()
        updateUI()
        return binding.root
    }

    private fun setupObserver() {
        setupAdapter = SetupAdapter {
            when (it) {
                "1" -> {
                    findNavController().navigate(SetupFragmentDirections.actionSetupFragmentToYayasanFragment())
                }
                "2" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1_cfVHHyjYxuop6lB1JdZLZnrra-1l4QM6ZJKWoSqOoc/edit?usp=sharing"
                    )
                }
                "3" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1LuRJKH1TXvc1PKejd2L9njWXTx_1pwH8dBcUqPCQSD4/edit?usp=sharing"
                    )
                }
                "4" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1Ng-EAGPQjrcuOvrqDinYHKqcs3kCMb9_20m7hRxKAmg/edit?usp=sharing"
                    )
                }
                "5" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1ENX-mzZdVpZr1fvX8WqctT9e1xJOpVhwuXXXVHYXEZc/edit?usp=sharing"
                    )
                }
                "6" -> {
                    findNavController().navigate(SetupFragmentDirections.actionSetupFragmentToAnalisaFragment())
                }
            }
        }
    }

    private fun updateUI() = with(binding) {
        rvSetup.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = setupAdapter
        }
    }

}