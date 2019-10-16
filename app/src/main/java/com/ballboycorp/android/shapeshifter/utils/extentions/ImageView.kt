package com.ballboycorp.android.shapeshifter.utils.extentions

import android.graphics.drawable.Animatable
import android.widget.ImageView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

fun ImageView.playAnimation(animDrawableId: Int) {
    val animDrawable = AnimatedVectorDrawableCompat.create(context, animDrawableId)
    setImageDrawable(animDrawable)
    (drawable as Animatable).start()
}