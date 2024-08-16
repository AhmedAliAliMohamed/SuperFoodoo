package com.example.kotlinappfood.ui.fragments.auth.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.Navigation
import com.example.kotlinappfood.databinding.FragmentSplashBinding
import com.example.kotlinappfood.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel,FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun initListeners() {
        Handler(Looper.getMainLooper()).postDelayed({
         Navigation.findNavController(binding.root).navigate(SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment())
        },3000)
    }

    override fun initViewModel() {
//        TODO("Not yet implemented")
    }

    override fun initObservers() {
//        TODO("Not yet implemented")
    }

    override fun initErrorObservers() {
//        TODO("Not yet implemented")
    }


}