package com.example.features.auth.repo
import com.example.model.UserModel
import com.example.features.auth.source.AuthRemote
import com.example.repository.SignInRepository
import jakarta.inject.Inject

class AuthRepositoryImp @Inject constructor
    (private val remoteDataSource: AuthRemote)
    : SignInRepository {
    override fun signIn(email: String, password: String): UserModel {
        TODO("Not yet implemented")
    }


}