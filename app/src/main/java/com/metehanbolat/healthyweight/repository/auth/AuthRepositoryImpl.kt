package com.metehanbolat.healthyweight.repository.auth

import com.google.firebase.auth.FirebaseAuth
import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.util.UiState

class AuthRepositoryImpl(
    val auth: FirebaseAuth
) : AuthRepository {

    override fun signIn() {

    }

    override fun signUp(member: Member, result: (UiState<Member>) -> Unit) {
        auth.createUserWithEmailAndPassword(member.email, member.password)
            .addOnSuccessListener { success ->
                result.invoke(UiState.Success(Member(email = success.user?.email!!, password = "123")))
            }
            .addOnFailureListener { failure ->
                result.invoke(UiState.Failure(failure.localizedMessage))
            }
    }
}