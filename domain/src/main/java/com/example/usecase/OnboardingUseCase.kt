package com.example.usecase

import com.example.model.OnboardingModel
import com.example.repository.OnboardingRepository

class OnboardingUseCase(
    private  val onboardingRepository: OnboardingRepository
) {
    operator fun  invoke(): OnboardingModel = onboardingRepository.getOnboardingModel()
}