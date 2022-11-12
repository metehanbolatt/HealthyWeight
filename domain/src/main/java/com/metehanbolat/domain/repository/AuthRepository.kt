package com.metehanbolat.domain.repository

import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.Member

interface AuthRepository {
    fun signIn(member: Member, result: (Resource<String>) -> Unit)
    fun signOut(result: (String) -> Unit)
    fun signUp(member: Member, result: (Resource<Member>) -> Unit)
    fun currentUser(result: (String) -> Unit)
}