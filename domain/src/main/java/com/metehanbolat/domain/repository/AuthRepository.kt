package com.metehanbolat.domain.repository

import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.User

interface AuthRepository {
    fun signIn(member: User, result: (Resource<String>) -> Unit)
    fun signOut(result: (String) -> Unit)
    fun signUp(member: User, result: (Resource<User>) -> Unit)
    fun currentUser(result: (String) -> Unit)
}