package com.example.kotlinappfood.ui.fragments.auth.signIn


import android.view.View
import androidx.navigation.Navigation
import com.example.kotlinappfood.R
import com.example.kotlinappfood.databinding.FragmentSignInBinding
import com.example.kotlinappfood.ui.base.BaseFragment

class SignInFragment :
    BaseFragment<SignInViewModel, FragmentSignInBinding>(FragmentSignInBinding::inflate) {
    override fun initListeners() {
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
        binding.createAccountTextView.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(SignInFragmentDirections.actionSingInFragmentToSignUpFragment())
        }

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

