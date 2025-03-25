package com.example.usecase

import com.example.model.UserModel
import com.example.repository.SignInRepository
import jakarta.inject.Inject

class SignInUseCase @Inject constructor(
    private val signInRepository: SignInRepository
){
    suspend fun invoke(email: String, password: String): UserModel = signInRepository.signIn(email, password)
}