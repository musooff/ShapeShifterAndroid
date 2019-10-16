package com.ballboycorp.android.shapeshifter.utils.extentions

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.toast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


fun Fragment.toast(message: String?) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Activity.toast(messageId: Int) {
    Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show()
}


fun Fragment.toast(messageId: Int) {
    Toast.makeText(context, messageId, Toast.LENGTH_SHORT).show()
}