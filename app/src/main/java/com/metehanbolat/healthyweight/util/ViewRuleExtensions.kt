package com.metehanbolat.healthyweight.util

import androidx.annotation.StringRes
import androidx.core.util.Predicate
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun TextInputEditText.validateRule(
    @StringRes errorString: Int,
    predicate: Predicate<String>
): Boolean {
    val textInputLayout = this.parent.parent as TextInputLayout

    this.doAfterTextChanged {
        textInputLayout.error = null
        textInputLayout.isErrorEnabled = false
    }

    return if (predicate.test(this.text.toString().trim())) {
        textInputLayout.error = this.context.getString(errorString)
        false
    } else true
}