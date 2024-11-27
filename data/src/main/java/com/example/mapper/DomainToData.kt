package com.example.mapper

import com.example.model.OnboardingModel


fun OnboardingModel.toDataModel(): OnboardingModel {
    return OnboardingModel(
        title = "",
        image = 0,
        description = "",
    )
}

fun OnboardingModel.toDomainModel(): OnboardingModel {
    return OnboardingModel(
        title = "",
        image = 0,
        description = "",
    )
}