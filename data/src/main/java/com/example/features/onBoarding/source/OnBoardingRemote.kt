package com.example.features.onBoarding.source

import com.example.model.OnboardingModel

interface OnBoardingRemote {
    fun  getOnboardingModel(): OnboardingModel
}