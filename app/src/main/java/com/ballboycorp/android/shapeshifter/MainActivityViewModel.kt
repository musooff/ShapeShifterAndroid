package com.ballboycorp.android.shapeshifter

import androidx.databinding.Bindable
import com.ballboycorp.android.shapeshifter.base.BaseObservableViewModel

class MainActivityViewModel: BaseObservableViewModel() {

    var isPlaying: Boolean = false
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.playing)
        }

    var isRepeat: Boolean = false
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.repeat)
        }
}