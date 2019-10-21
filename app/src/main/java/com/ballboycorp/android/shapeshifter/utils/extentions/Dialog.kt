package com.ballboycorp.android.shapeshifter.utils.extentions

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


/**
 * Created by muso on 2019-09-11.
 */

fun <T : DialogFragment> FragmentActivity.showDialog(factory: () -> T, vararg params: Pair<String, Any?>) {
    val dialog = factory()
    if (params.isNotEmpty()) {
        val bundle = Bundle()
        fillBundleArguments(bundle, params)
        dialog.arguments = bundle
    }
    dialog.show(supportFragmentManager, dialog::class.java.simpleName)
}

fun <T: DialogFragment> Fragment.showDialog(factory: () -> T, vararg params: Pair<String, Any?>) {
    val dialog = factory()
    if (params.isNotEmpty()) {
        val bundle = Bundle()
        fillBundleArguments(bundle, params)
        dialog.arguments = bundle
    }
    dialog.show(childFragmentManager, dialog::class.java.simpleName)
}