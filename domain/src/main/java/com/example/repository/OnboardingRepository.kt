package com.example.repository

import com.example.model.OnboardingModel

interface OnboardingRepository {
    fun  getOnboardingModel(): OnboardingModel
}