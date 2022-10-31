package com.metehanbolat.healthyweight.util

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

fun ImageView.setImageDrawableWithContextCompat(drawable: Int) {
    this.setImageDrawable(ContextCompat.getDrawable(this.context, drawable))
}

fun ImageView.setImageTintListWithContextCompat(imageTint: Int) {
    this.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this.context, imageTint))
}

fun TextView.setTextColorWithContextCompat(color: Int) {
    this.setTextColor(ContextCompat.getColor(this.context, color))
}

fun View.visible() {
    this.visibility = View.VISIBLE
}