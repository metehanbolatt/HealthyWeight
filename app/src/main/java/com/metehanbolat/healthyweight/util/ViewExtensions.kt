package com.metehanbolat.healthyweight.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
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

fun View.gone() {
    this.visibility = View.GONE
}


@SuppressLint("ClickableViewAccessibility")
fun View.lostFocusList(viewList: List<View>, activity: Activity) {
    this.setOnTouchListener { _, event ->
        viewList.forEach {
            val rect = Rect()
            it.getHitRect(rect)
            if (!rect.contains(event.x.toInt(), event.y.toInt())) {
                val manager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                manager.hideSoftInputFromWindow(this.windowToken, 0)
                this.clearFocus()
            }
        }
        true
    }
}