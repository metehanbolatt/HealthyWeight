package com.metehanbolat.healthyweight.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeActivityViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

    private val _signOut = MutableLiveData<String>()
    val signOut: LiveData<String> = _signOut

    fun signOut() {
        repository.signOut {
            _signOut.value = it
        }
    }
}