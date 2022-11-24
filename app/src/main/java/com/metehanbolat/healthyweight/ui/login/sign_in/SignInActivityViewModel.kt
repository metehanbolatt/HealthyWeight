package com.metehanbolat.healthyweight.ui.login.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.User
import com.metehanbolat.domain.repository.AuthRepository
import com.metehanbolat.healthyweight.model.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInActivityViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _signInMember = MutableLiveData<UserState>()
    val signInMember: LiveData<UserState> get() =  _signInMember

    private val _currentUser = MutableLiveData<UserState>()
    val currentUser: LiveData<UserState> get() =  _currentUser

    init {
        currentUserControl()
    }

    private fun currentUserControl() {
        repository.currentUser {
            _currentUser.value = UserState()
        }
    }

    fun signInMember(member: User) {
        repository.signIn(member = member) { result ->
            when (result) {
                is Resource.Success -> {
                    _signInMember.value = UserState(user = User(email = result.data))
                }
                is Resource.Failure -> {
                    _signInMember.value = UserState(error = result.error.toString())
                }
                is Resource.Loading -> {
                    _signInMember.value = UserState(isLoading = true)
                }
            }
        }

    }

}