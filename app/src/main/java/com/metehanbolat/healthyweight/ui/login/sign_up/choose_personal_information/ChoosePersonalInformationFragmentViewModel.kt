package com.metehanbolat.healthyweight.ui.login.sign_up.choose_personal_information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.domain.model.Member
import com.metehanbolat.domain.repository.AuthRepository
import com.metehanbolat.domain.repository.FirestoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChoosePersonalInformationFragmentViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val firestoreRepository: FirestoreRepository
): ViewModel() {

    private val _signUpMemberToAuth = MutableLiveData<com.metehanbolat.domain.common.Resource<Member>>()
    val signUpMemberToAuth: LiveData<com.metehanbolat.domain.common.Resource<Member>> get() =  _signUpMemberToAuth

    private val _signUpMemberToFirestore = MutableLiveData<com.metehanbolat.domain.common.Resource<Member>>()
    val signUpMemberToFirestore: LiveData<com.metehanbolat.domain.common.Resource<Member>> get() =  _signUpMemberToFirestore

    fun signUpMemberToAuth(member: Member) {
        _signUpMemberToAuth.value = com.metehanbolat.domain.common.Resource.Loading
        authRepository.signUp(member) {
            _signUpMemberToAuth.value = it
        }
    }

    fun signUpMemberToFirestore(member: Member) {
        _signUpMemberToFirestore.value = com.metehanbolat.domain.common.Resource.Loading
        firestoreRepository.signUpMemberToFirestore(member) {
            _signUpMemberToFirestore.value = it
        }
    }
}