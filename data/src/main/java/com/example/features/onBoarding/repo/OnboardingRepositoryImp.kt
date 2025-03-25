package com.example.features.onBoarding.repo

import com.example.features.onBoarding.source.OnBoardingRemote
import com.example.model.OnboardingModel
import com.example.repository.OnboardingRepository
import javax.inject.Inject

class OnboardingRepositoryImp @Inject constructor
    (
    private val remoteDataSource: OnBoardingRemote,
) : OnboardingRepository {
    override fun getOnboardingModel(): OnboardingModel {
        TODO("Not yet implemented")
    }


}