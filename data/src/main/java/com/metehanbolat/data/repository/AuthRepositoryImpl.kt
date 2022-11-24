package com.metehanbolat.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.metehanbolat.domain.model.User
import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.repository.AuthRepository

class AuthRepositoryImpl(
    val auth: FirebaseAuth
) : AuthRepository {

    override fun signIn(member: User, result: (Resource<String>) -> Unit) {
        result.invoke(Resource.Loading)
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

    override fun signUp(member: User, result: (Resource<User>) -> Unit) {
        result.invoke(Resource.Loading)
        auth.createUserWithEmailAndPassword(member.email!!, member.password!!)
            .addOnSuccessListener { success ->
                success.user?.let { result.invoke(Resource.Success(member)) }
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