package com.example.kotlinappfood.ui.fragments.auth.signUp

import android.view.View
import androidx.navigation.Navigation
import com.example.kotlinappfood.R
import com.example.kotlinappfood.databinding.FragmentSignUpBinding
import com.example.kotlinappfood.ui.base.BaseFragment
import com.example.kotlinappfood.ui.fragments.auth.signIn.SignInFragmentDirections

class SignUpFragment : BaseFragment<SignUpViewModel,FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun initListeners() {
        binding.imageButtonBack.setOnClickListener{requireActivity().onBackPressedDispatcher.onBackPressed()}
        binding.mobileEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textMobileHint.visibility = View.VISIBLE
                binding.mobileLayout.setBackgroundResource(R.drawable.linear_border_background_selected)
                binding.mobileEditText.hint = ""
            } else {
                if (binding.mobileEditText.text.isNotEmpty()) {
                    binding.textMobileHint.visibility = View.VISIBLE
                    binding.mobileLayout.setBackgroundResource(R.drawable.linear_border_background_unselected)

                } else {
                    binding.textMobileHint.visibility = View.GONE
                    binding.mobileLayout.setBackgroundResource(R.drawable.linear_border_background_unselected)
                    binding.mobileEditText.hint = getString(R.string.mobile)
                }
            }
        }
        binding.textViewLogin.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())

        }
    }

    override fun initViewModel() {

    }

    override fun initObservers() {
    }

    override fun initErrorObservers() {
    }
}