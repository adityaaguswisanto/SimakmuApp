package com.simakmu.simakmu.ui.yayasan.cabang

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.simakmu.simakmu.data.db.entities.Cabang
import com.simakmu.simakmu.databinding.FragmentCabangBinding
import com.simakmu.simakmu.ui.yayasan.YayasanViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CabangFragment : Fragment() {

    private val viewModel by viewModels<YayasanViewModel>()
    private lateinit var binding: FragmentCabangBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCabangBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {

        cabang()

        btnUbah.setOnClickListener {
            findNavController().navigate(
                CabangFragmentDirections.actionCabangFragmentToUbcabFragment(
                    cabang
                )
            )
        }
    }

    private fun cabang() = with(binding) {
        viewModel.loadCabang().observe(viewLifecycleOwner, {
            cabang = it
            if (it == null) {
                Log.i("TAG", "cabang: null")
            } else {
                txtNama.text = it.nama
                txtAlamat.text = it.alamat
                txtKelurahan.text = it.kelurahan
                txtKecamatan.text = it.kecamatan
                txtKota.text = it.kota
                txtProvinsi.text = it.provinsi
                txtNamaYayasan.text = it.yayasan
                txtStatus.text = it.status
                txtSk.text = it.sk
                txtTahunBerdiri.text = it.tahun
                txtJmlPengurus.text = it.pengurus
                txtNoTelephone.text = it.telp
            }
        })
    }

    companion object {
        private lateinit var cabang: Cabang
    }

}