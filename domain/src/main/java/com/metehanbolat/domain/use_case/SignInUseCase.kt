package com.metehanbolat.domain.use_case

import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.Member
import com.metehanbolat.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
){
    operator fun invoke(member: Member): Flow<Resource<Member>> = flow {
        try {
            emit(Resource.Loading)
            val user = repository.signIn(member)
            emit(Resource.Success(user))
        } catch (e: IOException) {
            emit(Resource.Failure(e.localizedMessage))
        }
    }
}