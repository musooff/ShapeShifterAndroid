package com.ballboycorp.android.shapeshifter.utils.extentions

import android.os.Handler

/**
 * Created by musooff on 2019-10-21.
 */

fun doDelayed(invoke: () -> Unit, duration: Long = 100) {
    Handler().postDelayed({ invoke() }, duration)
}