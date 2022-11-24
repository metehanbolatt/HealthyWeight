package com.metehanbolat.domain.repository

import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.User

interface FirestoreRepository {
    fun signUpMemberToFirestore(member: User, result: (Resource<User>) -> Unit)
}