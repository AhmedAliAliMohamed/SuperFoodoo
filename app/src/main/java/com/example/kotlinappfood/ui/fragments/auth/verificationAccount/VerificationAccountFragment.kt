package com.example.kotlinappfood.ui.fragments.auth.verificationAccount


import android.annotation.SuppressLint
import android.os.CountDownTimer
import com.example.kotlinappfood.databinding.FragmentVerificationAccountBinding
import com.example.kotlinappfood.ui.base.BaseFragment
import com.example.kotlinappfood.utilities.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerificationAccountFragment :
    BaseFragment<VerificationAccountViewModel, FragmentVerificationAccountBinding>(
        FragmentVerificationAccountBinding::inflate
    ) {
    val timer = 30000L
    val countDownTime = 1000L
    private var countDownTimer: CountDownTimer? = null

    override fun initListeners() {
        startResendTimer()
        binding.resendOtpButton.isEnabled = false
        binding.resendOtpButton.setOnClickListener {
           hideProgressDialog()
        }
        binding.imageButtonBack.setOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }
        binding.createAccountButton.setOnClickListener {
        }


    }

    override fun initViewModel() {
//        TODO("Not yet implemented")
    }

    override fun initObservers() {
//        TODO("Not yet implemented")
    }

    override fun initErrorObservers() {
        viewModel.dataState.observe(this) {state ->
           when (state) {
               is DataState.Loading -> {

               }
               is DataState.Success -> {

               }
               is DataState.Error -> {

               }
           }
        }
    }

    private fun startResendTimer() {
        countDownTimer = object : CountDownTimer(timer, countDownTime) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                // Check if the fragment is still attached before accessing binding
                if (isAdded) {
                    val secondsRemaining = millisUntilFinished / countDownTime
                    binding.textViewTime.text = " $secondsRemaining "
                }
            }

            override fun onFinish() {
                if (isAdded) {
                    binding.resendOtpButton.isEnabled = true
                }
            }
        }
        countDownTimer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer?.cancel()
    }

}