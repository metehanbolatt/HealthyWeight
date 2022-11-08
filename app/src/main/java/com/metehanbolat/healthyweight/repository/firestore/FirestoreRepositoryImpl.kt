package com.metehanbolat.healthyweight.repository.firestore

import com.google.firebase.firestore.FirebaseFirestore
import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.util.UiState

class FirestoreRepositoryImpl(
    val firestore: FirebaseFirestore
) : FirestoreRepository {

    override fun signUpMemberToFirestore(member: Member, result: (UiState<Member>) -> Unit) {
        firestore.collection("members").document().set(member)
            .addOnSuccessListener {
                result.invoke(UiState.Success(member))
            }
            .addOnFailureListener { failure ->
                result.invoke(UiState.Failure(failure.localizedMessage))
            }
    }
}