package com.simakmu.simakmu.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.simakmu.simakmu.data.db.entities.Cabang
import com.simakmu.simakmu.data.db.entities.Lembaga
import com.simakmu.simakmu.data.store.UserStore
import com.simakmu.simakmu.databinding.FragmentLoginBinding
import com.simakmu.simakmu.ui.yayasan.YayasanViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel by viewModels<YayasanViewModel>()
    private lateinit var binding: FragmentLoginBinding

    @Inject
    lateinit var userStore: UserStore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() = with(binding) {
        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() = with(binding) {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "Field masih kosong", Toast.LENGTH_SHORT)
                .show()
        } else if (email == "simakmu@gmail.com" && password == "simakmu") {
            lifecycleScope.launch {
                userStore.saveUser(email)
                viewModel.upsertCabang(
                    Cabang(
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                    )
                )
                viewModel.upsertLembaga(
                    Lembaga(
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                        "-",
                    )
                )
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            }
        } else {
            Toast.makeText(requireContext(), "Email atau password salah", Toast.LENGTH_SHORT)
                .show()
        }
    }

}