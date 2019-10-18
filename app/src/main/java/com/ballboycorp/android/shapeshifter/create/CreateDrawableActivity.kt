package com.ballboycorp.android.shapeshifter.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.android.shapeshifter.R
import com.ballboycorp.android.shapeshifter.create.adapter.ChildrenAdapter
import com.ballboycorp.android.shapeshifter.create.adapter.DragHelper
import com.ballboycorp.android.shapeshifter.create.model.Animation
import com.ballboycorp.android.shapeshifter.create.model.ClipPath
import com.ballboycorp.android.shapeshifter.create.model.Group
import com.ballboycorp.android.shapeshifter.create.model.Path
import com.ballboycorp.android.shapeshifter.databinding.ActivityCreateDrawableBinding
import kotlinx.android.synthetic.main.activity_create_drawable.*


class CreateDrawableActivity: AppCompatActivity() {

    private val adapter = ChildrenAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCreateDrawableBinding>(this, R.layout.activity_create_drawable)

        initialize()

    }

    private fun initialize() {

        children.adapter = adapter
        adapter.submitList(listOf(
            Group().apply {
                name = "oval_container"
            },
            Path().apply {
                name = "oval"
            },
            Animation().apply {
                name = "trimPathStart"
            },
            ClipPath().apply {
                name = "mask"
            },
            Path().apply {
                name = "ne_stem"
            },
            Animation().apply {
                name = "trimPathStart"
            },
            Path().apply {
                name = "nw_stem"
            },
            Animation().apply {
                name = "trimPathStart"
            },
            Animation().apply {
                name = "trimPathEnd"
            }
        ))

        val dragHelper = DragHelper(adapter)
        val touchHelper = ItemTouchHelper(dragHelper)
        touchHelper.attachToRecyclerView(children)
    }

    inner class ClickHandler {

    }
}