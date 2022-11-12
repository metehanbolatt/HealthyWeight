package com.metehanbolat.domain.model

data class Member(
    val name: String? = null,
    val surname: String? = null,
    val birthday: BirthdayModel? = null,
    val gender: String? = null,
    val weight: String? = null,
    val height: String? = null,
    val email: String,
    val password: String
)
