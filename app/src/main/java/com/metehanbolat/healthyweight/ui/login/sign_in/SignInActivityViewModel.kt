package com.metehanbolat.healthyweight.ui.login.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.repository.auth.AuthRepository
import com.metehanbolat.healthyweight.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInActivityViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _signInMember = MutableLiveData<UiState<FirebaseUser>>()
    val signInMember: LiveData<UiState<FirebaseUser>> get() =  _signInMember

    private val _currentUser = MutableLiveData<FirebaseUser>()
    val currentUser: LiveData<FirebaseUser> = _currentUser

    init {
        currentUserControl()
    }

    private fun currentUserControl() {
        repository.currentUser {
            _currentUser.value = it
        }
    }

    fun signInMember(member: Member) {
        _signInMember.value = UiState.Loading
        repository.signIn(member = member) {
            _signInMember.value = it
        }
    }

}