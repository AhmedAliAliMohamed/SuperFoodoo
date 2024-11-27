package com.example.source

import com.example.model.OnboardingModel

interface RemoteDataSource {
     fun getOnboardingModelFromRemote(): OnboardingModel
}