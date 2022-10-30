package com.metehanbolat.healthyweight.repository.auth

import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.util.UiState

interface AuthRepository {
    fun signIn()
    fun signUp(member: Member, result: (UiState<Member>) -> Unit)
}