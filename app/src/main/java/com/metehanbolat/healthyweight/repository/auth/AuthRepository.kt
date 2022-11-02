package com.metehanbolat.healthyweight.repository.auth

import com.google.firebase.auth.FirebaseUser
import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.util.UiState

interface AuthRepository {
    fun signIn(member: Member, result: (UiState<FirebaseUser>) -> Unit)
    fun signOut(result: (String) -> Unit)
    fun signUp(member: Member, result: (UiState<Member>) -> Unit)
    fun currentUser(result: (FirebaseUser) -> Unit)
}