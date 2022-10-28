package com.metehanbolat.healthyweight.ui.login.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.healthyweight.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInActivityViewModel @Inject constructor(
    val repository: AuthRepository
) : ViewModel() {

    private val _control = MutableLiveData<String>()
    val control: LiveData<String> = _control

    fun controlCheck(name: String) {
        _control.value = repository.signIn(name)
    }
}