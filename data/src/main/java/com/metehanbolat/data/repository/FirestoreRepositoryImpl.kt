package com.metehanbolat.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.User
import com.metehanbolat.domain.repository.FirestoreRepository

class FirestoreRepositoryImpl(
    val firestore: FirebaseFirestore
) : FirestoreRepository {

    override fun signUpMemberToFirestore(member: User, result: (Resource<User>) -> Unit) {
        result.invoke(Resource.Loading)
        firestore.collection("members").document().set(member)
            .addOnSuccessListener {
                result.invoke(Resource.Success(member))
            }
            .addOnFailureListener { failure ->
                result.invoke(Resource.Failure(failure.localizedMessage))
            }
    }
}