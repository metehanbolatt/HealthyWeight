package com.metehanbolat.domain.repository

import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.Member

interface FirestoreRepository {
    fun signUpMemberToFirestore(member: Member, result: (Resource<Member>) -> Unit)
}