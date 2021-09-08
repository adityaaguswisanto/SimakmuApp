package com.simakmu.simakmu.ui.iuran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.simakmu.simakmu.data.utils.spreadSheet
import com.simakmu.simakmu.databinding.FragmentIuranBinding
import com.simakmu.simakmu.ui.iuran.adapter.IuranAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IuranFragment : Fragment() {

    private lateinit var binding: FragmentIuranBinding
    private lateinit var iuranAdapter: IuranAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIuranBinding.inflate(inflater, container, false)
        setupObserver()
        updateUI()
        return binding.root
    }

    private fun setupObserver() {
        iuranAdapter = IuranAdapter {
            when(it){
                "1" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1mpNr5uc7_1S94dhVezG1zH2psGmWohIZtBPYsm1E2fA/edit?usp=sharing"
                    )
                }
                "2" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1TalDYFc8t2WLjs52rwc6H7XOCONF6FLatY0NkfCuke4/edit?usp=sharing"
                    )
                }
                "3" -> {
                    requireActivity().spreadSheet(
                        "https://docs.google.com/spreadsheets/d/1uLsA62X2QtrhhGPIJg7n4AnB3sy51KFSVUXsqJMhRrs/edit?usp=sharing"
                    )
                }
            }
        }
    }

    private fun updateUI() = with(binding) {
        rvIuran.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = iuranAdapter
        }
    }

}