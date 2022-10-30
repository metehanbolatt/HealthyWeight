package com.metehanbolat.healthyweight.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

fun ImageView.setImageWithContextCompat(image: Int) {
    this.setImageDrawable(ContextCompat.getDrawable(this.context, image))
}

fun TextView.setTextColorWithContextCompat(color: Int) {
    this.setTextColor(ContextCompat.getColor(this.context, color))
}

fun View.visible() {
    this.visibility = View.VISIBLE
}