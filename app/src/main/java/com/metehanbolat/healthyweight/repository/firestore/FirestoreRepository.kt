package com.metehanbolat.healthyweight.repository.firestore

import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.util.UiState

interface FirestoreRepository {
    fun signUpMemberToFirestore(member: Member, result: (UiState<Member>) -> Unit)
}