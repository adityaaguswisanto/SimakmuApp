package com.simakmu.simakmu.ui.yayasan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.simakmu.simakmu.databinding.FragmentYayasanBinding
import com.simakmu.simakmu.ui.yayasan.adapter.YayasanAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YayasanFragment : Fragment() {

    private lateinit var binding: FragmentYayasanBinding
    private lateinit var yayasanAdapter: YayasanAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYayasanBinding.inflate(inflater, container, false)
        setupObserver()
        updateUI()
        return binding.root
    }

    private fun setupObserver() {
        yayasanAdapter = YayasanAdapter {
            when(it){
                "1" -> {
                    findNavController().navigate(YayasanFragmentDirections.actionYayasanFragmentToCabangFragment())
                }
                "2" -> {
                    findNavController().navigate(YayasanFragmentDirections.actionYayasanFragmentToLembagaFragment())
                }
            }
        }
    }

    private fun updateUI() = with(binding) {
        rvYayasan.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext())
            adapter = yayasanAdapter
        }
    }

}