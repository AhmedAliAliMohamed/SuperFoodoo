package com.example.kotlinappfood.ui.fragments.auth.signIn


import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import com.example.kotlinappfood.R
import com.example.kotlinappfood.databinding.FragmentSignInBinding
import com.example.kotlinappfood.ui.base.BaseFragment


class SignInFragment :
    BaseFragment<SignInViewModel, FragmentSignInBinding>(FragmentSignInBinding::inflate) {
    override fun initListeners() {
//        TODO("Not yet implemented")
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

