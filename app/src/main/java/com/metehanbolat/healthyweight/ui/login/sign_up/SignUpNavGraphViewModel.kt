package com.metehanbolat.healthyweight.ui.login.sign_up

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpNavGraphViewModel @Inject constructor(

): ViewModel() {

    private val _chosenGender = MutableLiveData<String>()
    val chosenGender: LiveData<String> = _chosenGender

    fun setChosenGender(chosenGender: String) {
        _chosenGender.value = chosenGender
    }

}