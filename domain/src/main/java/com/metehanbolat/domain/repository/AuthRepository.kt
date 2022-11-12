package com.metehanbolat.domain.repository

import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.Member

interface AuthRepository {
    fun signIn(member: Member): Member
    fun signOut(result: (String) -> Unit)
    fun signUp(member: Member, result: (Resource<Member>) -> Unit)
    fun currentUser(result: (Member) -> Unit)
}