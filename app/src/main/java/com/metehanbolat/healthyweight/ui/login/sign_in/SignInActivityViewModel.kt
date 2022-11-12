package com.metehanbolat.healthyweight.ui.login.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.Member
import com.metehanbolat.domain.repository.AuthRepository
import com.metehanbolat.domain.use_case.SignInUseCase
import com.metehanbolat.healthyweight.model.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SignInActivityViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _signInMember = MutableLiveData<UserState>()
    val signInMember: LiveData<UserState> get() =  _signInMember

    private val _currentUser = MutableLiveData<UserState>()
    val currentUser: LiveData<UserState> = _currentUser

    init {
        currentUserControl()
    }

    private fun currentUserControl() {

    }

    fun signInMember(member: Member) {
        signInUseCase(member).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _signInMember.value = UserState(isLoading = true)
                }
                is Resource.Success -> {
                    _signInMember.value = UserState(user = result.data)
                }
                is Resource.Failure -> {
                    _signInMember.value = UserState(error = result.error ?: "An unexpected error occurred!")
                }
            }
        }
    }

}