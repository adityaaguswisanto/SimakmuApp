package com.simakmu.simakmu.ui.yayasan.cabang.ubcab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.simakmu.simakmu.data.db.entities.Cabang
import com.simakmu.simakmu.databinding.FragmentUbcabBinding
import com.simakmu.simakmu.ui.yayasan.YayasanViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UbcabFragment : Fragment() {

    private val args by navArgs<UbcabFragmentArgs>()
    private val viewModel by viewModels<YayasanViewModel>()
    private lateinit var binding: FragmentUbcabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUbcabBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {

        loadCabang()

        btnSimpan.setOnClickListener {
            upsertCabang()
        }
    }

    private fun loadCabang() = with(binding) {
        edtNama.setText(args.cabang.nama)
        edtAlamat.setText(args.cabang.alamat)
        edtKelurahan.setText(args.cabang.kelurahan)
        edtKecamatan.setText(args.cabang.kecamatan)
        edtKota.setText(args.cabang.kota)
        edtProvinsi.setText(args.cabang.provinsi)
        edtNamaYayasan.setText(args.cabang.yayasan)
        edtStatus.setText(args.cabang.status)
        edtSk.setText(args.cabang.sk)
        edtTahunBerdiri.setText(args.cabang.tahun)
        edtJmlPengurus.setText(args.cabang.pengurus)
        edtNoTelephone.setText(args.cabang.telp)
    }

    private fun upsertCabang() = with(binding) {
        val nama = edtNama.text.toString().trim()
        val alamat = edtAlamat.text.toString().trim()
        val kelurahan = edtKelurahan.text.toString().trim()
        val kecamatan = edtKecamatan.text.toString().trim()
        val kota = edtKota.text.toString().trim()
        val provinsi = edtProvinsi.text.toString().trim()
        val yayasan = edtNamaYayasan.text.toString().trim()
        val status = edtStatus.text.toString().trim()
        val sk = edtSk.text.toString().trim()
        val tahun = edtTahunBerdiri.text.toString().trim()
        val pengurus = edtJmlPengurus.text.toString().trim()
        val telp = edtNoTelephone.text.toString().trim()

        if (nama.isEmpty() ||
            alamat.isEmpty() ||
            kelurahan.isEmpty() ||
            kecamatan.isEmpty() ||
            kota.isEmpty() ||
            provinsi.isEmpty() ||
            yayasan.isEmpty() ||
            status.isEmpty() ||
            sk.isEmpty() ||
            tahun.isEmpty() ||
            pengurus.isEmpty() ||
            telp.isEmpty()
        ) {
            Toast.makeText(requireContext(), "Field masih kosong !", Toast.LENGTH_SHORT).show()
        } else {
            lifecycleScope.launch {
                viewModel.upsertCabang(
                    Cabang(
                        nama,
                        alamat,
                        kelurahan,
                        kecamatan,
                        kota,
                        provinsi,
                        yayasan,
                        status,
                        sk,
                        tahun,
                        pengurus,
                        telp
                    )
                )
                Toast.makeText(requireContext(), "Data berhasil disimpan", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

}