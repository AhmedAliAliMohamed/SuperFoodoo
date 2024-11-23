package com.example.kotlinappfood.ui.fragments.auth.signIn


import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.kotlinappfood.R
import com.example.kotlinappfood.databinding.FragmentSignInBinding
import com.example.kotlinappfood.ui.base.BaseFragment
import com.example.kotlinappfood.utilities.login
import com.example.kotlinappfood.utilities.password
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction

class SignInFragment :
    BaseFragment<SignInViewModel, FragmentSignInBinding>(FragmentSignInBinding::inflate) {
    @SuppressLint("CheckResult")
    override fun initListeners() {
        binding.loginButton.isEnabled  = false
        binding.countryCodePicker.registerCarrierNumberEditText(binding.mobileEditText)
        binding.mobileEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textMobileHint.visibility = View.VISIBLE
                binding.mobileLayout.setBackgroundResource(R.drawable.linear_border_background_selected)
                binding.mobileEditText.hint = ""
            } else {
                if (binding.mobileEditText.text?.isNotEmpty() == true) {
                    binding.textMobileHint.visibility = View.VISIBLE
                    binding.mobileLayout.setBackgroundResource(R.drawable.linear_border_background_unselected)

                } else {
                    binding.textMobileHint.visibility = View.GONE
                    binding.mobileLayout.setBackgroundResource(R.drawable.linear_border_background_unselected)
                    binding.mobileEditText.hint = getString(R.string.mobile)
                }
            }
        }
        binding.createAccountTextView.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(SignInFragmentDirections.actionSingInFragmentToSignUpFragment())
        }

        val  loginName =  binding.mobileEditeTextField.login(1,1,
            R.string.field_required,R.string.invalid_email_or_mobile)
        val password = binding.passwordEditeTextField.password(1,1,
            R.string.field_required,R.string.password_too_short)

        Observable.combineLatest(
            loginName,
            password,
            BiFunction { t1: Boolean, t2: Boolean -> t1 && t2 }
        ).distinctUntilChanged()
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                binding.loginButton.isEnabled = it
                binding.loginButton.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.primary_color))
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



