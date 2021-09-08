package com.simakmu.simakmu.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import com.simakmu.simakmu.data.store.UserStore
import com.simakmu.simakmu.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    @Inject
    lateinit var userStore: UserStore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateUI() {
        Handler(Looper.getMainLooper()).postDelayed({
            userStore.authToken.asLiveData().observe(viewLifecycleOwner, {
                if (it == null) {
                    findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
                } else {
                    findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
                }
            })
        }, 3000)
    }

}