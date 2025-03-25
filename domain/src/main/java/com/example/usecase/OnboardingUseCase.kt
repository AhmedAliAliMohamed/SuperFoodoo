package com.example.usecase

import com.example.model.OnboardingModel
import com.example.repository.OnboardingRepository
import jakarta.inject.Inject

class OnboardingUseCase @Inject constructor(
    private  val onboardingRepository: OnboardingRepository
) {
    suspend operator fun  invoke(): OnboardingModel = onboardingRepository.getOnboardingModel()
}