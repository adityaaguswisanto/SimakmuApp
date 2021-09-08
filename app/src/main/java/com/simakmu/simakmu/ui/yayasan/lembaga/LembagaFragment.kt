package com.simakmu.simakmu.ui.yayasan.lembaga

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.simakmu.simakmu.data.db.entities.Lembaga
import com.simakmu.simakmu.databinding.FragmentLembagaBinding
import com.simakmu.simakmu.ui.yayasan.YayasanViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LembagaFragment : Fragment() {

    private val viewModel by viewModels<YayasanViewModel>()
    private lateinit var binding: FragmentLembagaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLembagaBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {

        lembaga()

        btnUbah.setOnClickListener {
            findNavController().navigate(
                LembagaFragmentDirections.actionLembagaFragmentToUblemFragment(
                    lembaga
                )
            )
        }
    }

    private fun lembaga() = with(binding) {
        viewModel.loadLembaga().observe(viewLifecycleOwner, {
            lembaga = it
            if (it == null) {
                Log.i("TAG", "lembaga: null")
            } else {
                txtNama.text = it.nama
                txtAlamat.text = it.alamat
                txtNoTelephone.text = it.telp
                txtEmail.text = it.email
                txtPeriode.text = it.periode
                txtKetua.text = it.ketua
                txtMudir.text = it.mudir
                txtSekretaris.text = it.sekretaris
                txtBendahara.text = it.bendahara
                txtAdministrasi.text = it.administrasi
            }
        })
    }

    companion object {
        private lateinit var lembaga: Lembaga
    }

}