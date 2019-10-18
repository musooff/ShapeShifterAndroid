package com.ballboycorp.android.shapeshifter.create.model

class Animation: Child() {
    var name: String? = null
    var startTime: Long = 0
    var endTime: Long = 0
    var fromValue: Float = 0f
    var toValue: Float = 0f
}