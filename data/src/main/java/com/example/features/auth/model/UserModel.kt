package com.example.features.auth.model

data class UserModel(
    val name: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val address : String,
    val password : String,
    val phoneNumber : String,
    val image : String,
    val token : String
)
