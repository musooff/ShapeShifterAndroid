package com.ballboycorp.android.shapeshifter.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import com.ballboycorp.android.shapeshifter.R
import com.ballboycorp.android.shapeshifter.create.adapter.LayerAdapter
import com.ballboycorp.android.shapeshifter.create.adapter.DragHelper
import com.ballboycorp.android.shapeshifter.create.dialog.CreateLayerDialog
import com.ballboycorp.android.shapeshifter.create.model.*
import com.ballboycorp.android.shapeshifter.databinding.ActivityCreateDrawableBinding
import com.ballboycorp.android.shapeshifter.utils.extentions.showDialog
import kotlinx.android.synthetic.main.activity_create_drawable.*


class CreateDrawableActivity : AppCompatActivity() {

    private val adapter = LayerAdapter()
    private val layers = listOf(
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
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCreateDrawableBinding>(
            this,
            R.layout.activity_create_drawable
        )

        initialize()

    }

    private fun initialize() {

        layerRv.adapter = adapter
        adapter.submitList(layers)

        val dragHelper = DragHelper(adapter)
        val touchHelper = ItemTouchHelper(dragHelper)
        touchHelper.attachToRecyclerView(layerRv)

        add.setOnClickListener {
            showDialog(::CreateLayerDialog)
        }
    }

    fun addLayer(layerType: LayerType) {
        when (layerType) {
            LayerType.GROUP -> adapter.addItem(Group().apply {
                name = "groupName"
            })
            LayerType.PATH -> adapter.addItem(Path().apply {
                name = "pathName"
            })
            else -> adapter.addItem(ClipPath().apply {
                name = "clipPathName"
            })
        }
    }

    inner class ClickHandler {

    }
}