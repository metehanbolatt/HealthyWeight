package com.metehanbolat.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.Member
import com.metehanbolat.domain.repository.FirestoreRepository

class FirestoreRepositoryImpl(
    val firestore: FirebaseFirestore
) : FirestoreRepository {

    override fun signUpMemberToFirestore(member: Member, result: (Resource<Member>) -> Unit) {
        firestore.collection("members").document().set(member)
            .addOnSuccessListener {
                result.invoke(Resource.Success(member))
            }
            .addOnFailureListener { failure ->
                result.invoke(Resource.Failure(failure.localizedMessage))
            }
    }
}