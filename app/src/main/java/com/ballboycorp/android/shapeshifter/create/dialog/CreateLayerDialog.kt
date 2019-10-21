package com.ballboycorp.android.shapeshifter.create.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ballboycorp.android.shapeshifter.create.CreateDrawableActivity
import com.ballboycorp.android.shapeshifter.create.model.LayerType
import com.ballboycorp.android.shapeshifter.databinding.DialogCreateLayerBinding
import com.ballboycorp.android.shapeshifter.utils.extentions.doDelayed

/**
 * Created by musooff on 2019-10-18.
 */

class CreateLayerDialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogCreateLayerBinding.inflate(inflater, container,false)
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    inner class ClickHandler {
        fun onClickType(layerType: LayerType) {
            (activity as CreateDrawableActivity?)?.addLayer(layerType)
            doDelayed({dismiss()})
        }
    }
}