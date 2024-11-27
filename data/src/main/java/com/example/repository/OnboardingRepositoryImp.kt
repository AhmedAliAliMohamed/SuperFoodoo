package com.example.repository

import com.example.model.OnboardingModel
import com.example.source.LocalDataSource
import com.example.source.RemoteDataSource
import javax.inject.Inject

class OnboardingRepositoryImp @Inject constructor
    (private val remoteDataSource: RemoteDataSource,
     private val localDataSource: LocalDataSource) : OnboardingRepository {

    override fun getOnboardingModel(): OnboardingModel = localDataSource.getOnboardingModelFomLocal()



}