package com.example.repository

import com.example.model.UserModel


interface SignInRepository {
    fun signIn(email: String, password: String): UserModel
}