package com.metehanbolat.healthyweight.ui.login.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.repository.auth.AuthRepository
import com.metehanbolat.healthyweight.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInActivityViewModel @Inject constructor(
    val repository: AuthRepository
) : ViewModel() {

    private val _signUpMember = MutableLiveData<UiState<Member>>()
    val signUpMember: LiveData<UiState<Member>> get() =  _signUpMember

    /*
    fun signUpMember(member: Member) {
        _signUpMember.value = UiState.Loading
        repository.signUp(member) { _signUpMember.value = it }
    }
     */
}