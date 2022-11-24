package com.metehanbolat.healthyweight.model

import com.metehanbolat.domain.model.User

data class UserState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
)