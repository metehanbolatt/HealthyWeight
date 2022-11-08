package com.metehanbolat.healthyweight.ui.login.sign_up.choosegender

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.healthyweight.R
import com.metehanbolat.healthyweight.ui.login.sign_up.choosegender.model.ChosenGenderInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseGenderFragmentViewModel @Inject constructor(

): ViewModel() {

    private val _chosenMale = MutableLiveData<ChosenGenderInstance>()
    val chosenMale: LiveData<ChosenGenderInstance> = _chosenMale

    private val _chosenFemale = MutableLiveData<ChosenGenderInstance>()
    val chosenFemale: LiveData<ChosenGenderInstance> = _chosenFemale

    fun chosenMale(context: Context) {
        _chosenMale.value = ChosenGenderInstance(
            genderMaleColor = R.color.gender_male_color,
            genderFemaleColor = R.color.gender_color_unselected,
            selectedGenderText = context.resources.getString(R.string.male),
            selectedGenderTextColor = R.color.gender_male_color
        )
    }

    fun chosenFemale(context: Context) {
        _chosenFemale.value = ChosenGenderInstance(
            genderMaleColor = R.color.gender_color_unselected,
            genderFemaleColor = R.color.gender_female_color,
            selectedGenderText = context.resources.getString(R.string.female),
            selectedGenderTextColor = R.color.gender_female_color
        )
    }

}