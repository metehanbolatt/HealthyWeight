package com.metehanbolat.healthyweight.ui.login.sign_up.choosegender

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.ui.login.sign_up.choosegender.model.ChosenGenderInstance
import com.metehanbolat.healthyweight.ui.login.sign_up.choosegender.model.Gender
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseGenderFragmentViewModel @Inject constructor(

): ViewModel() {

    private val _chosenMale = MutableLiveData<ChosenGenderInstance>()
    val chosenMale: LiveData<ChosenGenderInstance> = _chosenMale

    private val _chosenFemale = MutableLiveData<ChosenGenderInstance>()
    val chosenFemale: LiveData<ChosenGenderInstance> = _chosenFemale

    fun chosenMale() {
        _chosenMale.value = ChosenGenderInstance(
            genderMaleColor = R.color.gender_male_color,
            genderFemaleColor = R.color.gender_color_unselected,
            selectedGenderText = Gender.MALE.gender,
            selectedGenderTextColor = R.color.gender_male_color
        )
    }

    fun chosenFemale() {
        _chosenFemale.value = ChosenGenderInstance(
            genderMaleColor = R.color.gender_color_unselected,
            genderFemaleColor = R.color.gender_female_color,
            selectedGenderText = Gender.FEMALE.gender,
            selectedGenderTextColor = R.color.gender_female_color
        )
    }

}