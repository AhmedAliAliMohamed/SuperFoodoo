package com.example.features.auth.source

import com.example.features.auth.model.UserModel

interface AuthRemote {
    fun signIn(email: String, password: String): UserModel
}