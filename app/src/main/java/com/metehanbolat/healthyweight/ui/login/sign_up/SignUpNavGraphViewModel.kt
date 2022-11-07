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

    private val _chosenHeight = MutableLiveData<Int>()
    val chosenHeight: LiveData<Int> = _chosenHeight

    private val _chosenWeight = MutableLiveData<Int>()
    val chosenWeight: LiveData<Int> = _chosenWeight

    fun setChosenGender(chosenGender: String) {
        _chosenGender.value = chosenGender
    }

    fun setChosenHeight(chosenHeight: Int) {
        _chosenHeight.value = chosenHeight
    }

    fun setChosenWeight(chosenWeight: Int) {
        _chosenWeight.value = chosenWeight
    }

}