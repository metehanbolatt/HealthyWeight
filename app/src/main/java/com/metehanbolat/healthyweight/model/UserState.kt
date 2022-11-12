package com.metehanbolat.healthyweight.model

import com.metehanbolat.domain.model.Member

data class UserState(
    val isLoading: Boolean = false,
    val user: Member? = null,
    val error: String = ""
)