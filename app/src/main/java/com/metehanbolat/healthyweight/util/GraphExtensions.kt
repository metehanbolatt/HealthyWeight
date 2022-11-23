package com.metehanbolat.healthyweight.util

import androidx.navigation.NavController

fun NavController.safeNavigate(destination: Int) {
    if (this.currentDestination?.id != destination) {
        this.popBackStack()
        this.navigate(destination)
    }
}