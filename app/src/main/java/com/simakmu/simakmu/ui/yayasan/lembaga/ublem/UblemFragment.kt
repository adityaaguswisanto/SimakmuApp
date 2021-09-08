package com.simakmu.simakmu.ui.yayasan.lembaga.ublem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.simakmu.simakmu.data.db.entities.Lembaga
import com.simakmu.simakmu.databinding.FragmentUblemBinding
import com.simakmu.simakmu.ui.yayasan.YayasanViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UblemFragment : Fragment() {

    private val args by navArgs<UblemFragmentArgs>()
    private val viewModel by viewModels<YayasanViewModel>()
    private lateinit var binding: FragmentUblemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUblemBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {

        loadLembaga()

        btnSimpan.setOnClickListener {
            upsertLembaga()
        }
    }

    private fun loadLembaga() = with(binding) {
        edtNama.setText(args.lembaga.nama)
        edtAlamat.setText(args.lembaga.alamat)
        edtNoTelephone.setText(args.lembaga.telp)
        edtEmail.setText(args.lembaga.email)
        edtPeriode.setText(args.lembaga.periode)
        edtKetua.setText(args.lembaga.ketua)
        edtMudir.setText(args.lembaga.mudir)
        edtSekretaris.setText(args.lembaga.sekretaris)
        edtBendahara.setText(args.lembaga.bendahara)
        edtAdministrasi.setText(args.lembaga.administrasi)
    }

    private fun upsertLembaga() = with(binding) {
        val nama = edtNama.text.toString().trim()
        val alamat = edtAlamat.text.toString().trim()
        val telp = edtNoTelephone.text.toString().trim()
        val email = edtEmail.text.toString().trim()
        val periode = edtPeriode.text.toString().trim()
        val ketua = edtKetua.text.toString().trim()
        val mudir = edtMudir.text.toString().trim()
        val sekretaris = edtSekretaris.text.toString().trim()
        val bendahara = edtBendahara.text.toString().trim()
        val administrasi = edtAdministrasi.text.toString().trim()

        if (nama.isEmpty() ||
            alamat.isEmpty() ||
            telp.isEmpty() ||
            email.isEmpty() ||
            periode.isEmpty() ||
            ketua.isEmpty() ||
            mudir.isEmpty() ||
            sekretaris.isEmpty() ||
            bendahara.isEmpty() ||
            administrasi.isEmpty()
        ) {
            Toast.makeText(requireContext(), "Field masih kosong !", Toast.LENGTH_SHORT).show()
        } else {
            lifecycleScope.launch {
                viewModel.upsertLembaga(
                    Lembaga(
                        nama,
                        alamat,
                        telp,
                        email,
                        periode,
                        ketua,
                        mudir,
                        sekretaris,
                        bendahara,
                        administrasi
                    )
                )
                Toast.makeText(requireContext(), "Data berhasil disimpan", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

}