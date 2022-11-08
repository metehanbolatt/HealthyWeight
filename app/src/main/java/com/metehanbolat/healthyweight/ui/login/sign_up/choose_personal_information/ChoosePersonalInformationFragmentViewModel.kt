package com.metehanbolat.healthyweight.ui.login.sign_up.choose_personal_information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.healthyweight.model.auth.Member
import com.metehanbolat.healthyweight.repository.auth.AuthRepository
import com.metehanbolat.healthyweight.repository.firestore.FirestoreRepository
import com.metehanbolat.healthyweight.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChoosePersonalInformationFragmentViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val firestoreRepository: FirestoreRepository
): ViewModel() {

    private val _signUpMemberToAuth = MutableLiveData<UiState<Member>>()
    val signUpMemberToAuth: LiveData<UiState<Member>> get() =  _signUpMemberToAuth

    private val _signUpMemberToFirestore = MutableLiveData<UiState<Member>>()
    val signUpMemberToFirestore: LiveData<UiState<Member>> get() =  _signUpMemberToFirestore

    fun signUpMemberToAuth(member: Member) {
        _signUpMemberToAuth.value = UiState.Loading
        authRepository.signUp(member) {
            _signUpMemberToAuth.value = it
        }
    }

    fun signUpMemberToFirestore(member: Member) {
        _signUpMemberToFirestore.value = UiState.Loading
        firestoreRepository.signUpMemberToFirestore(member) {
            _signUpMemberToFirestore.value = it
        }
    }
}