package com.example.error

class Error : Exception() {
    override val message: String
        get() = "Domain Error"
}