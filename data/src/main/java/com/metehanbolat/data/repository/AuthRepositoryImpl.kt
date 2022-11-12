package com.metehanbolat.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.metehanbolat.domain.model.Member
import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.repository.AuthRepository

class AuthRepositoryImpl(
    val auth: FirebaseAuth
) : AuthRepository {

    override fun signIn(member: Member, result: (Resource<String>) -> Unit) {
        auth.signInWithEmailAndPassword(member.email!!, member.password!!)
            .addOnSuccessListener { success ->
                success.user?.let { result.invoke(Resource.Success(it.email ?: "")) }
            }
            .addOnFailureListener { failure ->
                result.invoke(Resource.Failure(failure.localizedMessage))
            }

    }

    override fun signOut(result: (String) -> Unit) {
        auth.signOut()
        if (auth.currentUser == null) {
            result.invoke("Good Bye")
        }
    }

    override fun signUp(member: Member, result: (Resource<Member>) -> Unit) {
        auth.createUserWithEmailAndPassword(member.email!!, member.password!!)
            .addOnSuccessListener { success ->
                result.invoke(Resource.Success(member))
            }
            .addOnFailureListener { failure ->
                result.invoke(Resource.Failure(failure.localizedMessage))
            }
    }

    override fun currentUser(result: (String) -> Unit) {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            result.invoke(currentUser.email ?: "")
        }
    }
}