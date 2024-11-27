package com.example.error

class DomainError : Exception() {
    override val message: String
        get() = "Domain Error"
}