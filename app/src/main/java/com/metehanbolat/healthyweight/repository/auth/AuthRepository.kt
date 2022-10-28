package com.metehanbolat.healthyweight.repository.auth

interface AuthRepository {
    fun signIn(name: String): String
    fun signUp()
}