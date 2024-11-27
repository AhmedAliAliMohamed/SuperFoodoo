package com.example.source

import com.example.model.OnboardingModel

interface LocalDataSource {
    fun getOnboardingModelFomLocal(): OnboardingModel
}