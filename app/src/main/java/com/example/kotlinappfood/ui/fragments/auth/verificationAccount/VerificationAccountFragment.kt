package com.example.kotlinappfood.ui.fragments.auth.verificationAccount


import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.widget.Toast
import com.example.kotlinappfood.databinding.FragmentVerificationAccountBinding
import com.example.kotlinappfood.ui.base.BaseFragment

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
            Toast.makeText(requireContext(), "Resend", Toast.LENGTH_SHORT).show()
        }
        binding.imageButtonBack.setOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }

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