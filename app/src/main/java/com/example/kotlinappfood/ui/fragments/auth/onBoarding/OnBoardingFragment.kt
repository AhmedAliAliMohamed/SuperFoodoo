package com.example.kotlinappfood.ui.fragments.auth.onBoarding

import android.view.View
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinappfood.adapters.OnBoardingAdapter
import com.example.kotlinappfood.databinding.FragmentOnBoardingBinding
import com.example.kotlinappfood.ui.base.BaseFragment
import com.example.kotlinappfood.utilities.CommonMethods
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment :
    BaseFragment<OnBoardingViewModel, FragmentOnBoardingBinding>(FragmentOnBoardingBinding::inflate) {

    override fun initListeners() {
        val onBoardingAdapter = OnBoardingAdapter(viewModel.getListForOnBoarding(requireContext()))
        binding.onboardingViewPager.adapter = onBoardingAdapter
        binding.viewPagerIndicator.attachTo(binding.onboardingViewPager)
        binding.onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position >= viewModel.getListForOnBoarding(requireContext()).size - 1) {
                    binding.skipTextView.visibility = View.INVISIBLE
                    binding.createAccountButton.visibility = View.VISIBLE
                    binding.loginButton.visibility = View.VISIBLE
                    binding.createAccountButton.startAnimation(
                        viewModel.getAnimationFroGetStartedButton(
                            requireContext()
                        )
                    )
                    binding.loginButton.startAnimation(
                        viewModel.getAnimationFroGetStartedButton(
                            requireContext()
                        )
                    )
                } else {
                    binding.skipTextView.visibility = View.VISIBLE
                    binding.createAccountButton.clearAnimation()
                    binding.loginButton.clearAnimation()
                    binding.createAccountButton.visibility = View.INVISIBLE
                    binding.loginButton.visibility = View.INVISIBLE
                }
                super.onPageSelected(position)
            }
        })

        binding.languageImageButton.setOnClickListener {
            CommonMethods.showLanguageDialog(requireContext(), layoutInflater, requireActivity())
        }
        binding.skipTextView.setOnClickListener {}
        binding.createAccountButton.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToSignUpFragment())
        }
        binding.loginButton.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToSignInFragment())
        }

        binding.skipTextView.setOnClickListener{
            binding.onboardingViewPager.currentItem =  viewModel.getListForOnBoarding(requireContext()).size - 1
        }
    }

    override fun initViewModel() {
    }

    override fun initObservers() {
    }

    override fun initErrorObservers() {
    }


}