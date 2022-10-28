package com.metehanbolat.healthyweight.repository.auth

import com.google.firebase.auth.FirebaseAuth

class AuthRepositoryImpl(val auth: FirebaseAuth): AuthRepository {

    override fun signIn(name: String): String {
        return name
    }

    override fun signUp() {

    }
}