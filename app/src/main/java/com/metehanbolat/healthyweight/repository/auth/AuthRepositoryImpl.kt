package com.metehanbolat.healthyweight.repository.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.util.UiState

class AuthRepositoryImpl(
    val auth: FirebaseAuth
) : AuthRepository {

    override fun signIn(member: Member, result: (UiState<FirebaseUser>) -> Unit) {
        auth.signInWithEmailAndPassword(member.email, member.password)
            .addOnSuccessListener { success ->
                success.user?.let { result.invoke(UiState.Success(it)) }
            }
            .addOnFailureListener { failure ->
                result.invoke(UiState.Failure(failure.localizedMessage))
            }

    }

    override fun signOut(result: (String) -> Unit) {
        auth.signOut()
        if (auth.currentUser == null) {
            result.invoke("Good Bye")
        }
    }

    override fun signUp(member: Member, result: (UiState<Member>) -> Unit) {
        auth.createUserWithEmailAndPassword(member.email, member.password)
            .addOnSuccessListener { success ->
                result.invoke(UiState.Success(member))
            }
            .addOnFailureListener { failure ->
                result.invoke(UiState.Failure(failure.localizedMessage))
            }
    }

    override fun currentUser(result: (FirebaseUser) -> Unit) {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            result.invoke(currentUser)
        }
    }
}