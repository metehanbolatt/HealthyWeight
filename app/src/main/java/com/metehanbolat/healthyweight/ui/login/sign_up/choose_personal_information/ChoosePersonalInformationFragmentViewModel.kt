package com.metehanbolat.healthyweight.ui.login.sign_up.choose_personal_information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.domain.common.Resource
import com.metehanbolat.domain.model.User
import com.metehanbolat.domain.repository.AuthRepository
import com.metehanbolat.domain.repository.FirestoreRepository
import com.metehanbolat.healthyweight.model.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChoosePersonalInformationFragmentViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val firestoreRepository: FirestoreRepository
): ViewModel() {

    private val _signUpMemberToAuth = MutableLiveData<UserState>()
    val signUpMemberToAuth: LiveData<UserState> get() =  _signUpMemberToAuth

    private val _signUpMemberToFirestore = MutableLiveData<UserState>()
    val signUpMemberToFirestore: LiveData<UserState> get() =  _signUpMemberToFirestore

    private fun signUpMemberToAuth(user: User) {
        authRepository.signUp(user) { result ->
            when (result) {
                is Resource.Success -> {
                    _signUpMemberToAuth.value = UserState(user = result.data)
                }
                is Resource.Failure -> {
                    _signUpMemberToAuth.value = UserState(error = result.error.toString())
                }
                is Resource.Loading -> {
                    _signUpMemberToAuth.value = UserState(isLoading = true)
                }
            }
        }
    }

    fun signUpMemberToFirestore(user: User) {
        firestoreRepository.signUpMemberToFirestore(user) { result ->
            when (result) {
                is Resource.Success -> {
                    _signUpMemberToFirestore.value = UserState(user = result.data)
                    signUpMemberToAuth(result.data)
                }
                is Resource.Failure -> {
                    _signUpMemberToFirestore.value = UserState(error = result.error.toString())
                }
                is Resource.Loading -> {
                    _signUpMemberToFirestore.value = UserState(isLoading = true)
                }
            }
        }
    }
}