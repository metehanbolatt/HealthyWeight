package com.metehanbolat.healthyweight.model.auth

data class Member(
    val name: String? = null,
    val surname: String? = null,
    val age: String? = null,
    val gender: String? = null,
    val weight: String? = null,
    val height: String? = null,
    val email: String,
    val password: String
)
