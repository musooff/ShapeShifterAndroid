package com.ballboycorp.android.shapeshifter.create.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.android.shapeshifter.R
import com.ballboycorp.android.shapeshifter.create.model.*
import com.ballboycorp.android.shapeshifter.databinding.*


class LayerAdapter: RecyclerView.Adapter<LayerAdapter.ChildrenViewHolder>(), DragHelper.ActionCompletionContract {

    private var mItems = mutableListOf<Layer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenViewHolder {
        val binding = when(viewType) {
            LayerType.PATH.id -> DataBindingUtil.inflate<ItemLayerPathBinding>(LayoutInflater.from(parent.context), R.layout.item_layer_path, parent, false)
            LayerType.GROUP.id -> DataBindingUtil.inflate<ItemLayerGroupBinding>(LayoutInflater.from(parent.context), R.layout.item_layer_group, parent, false)
            LayerType.CLIP_PATH.id -> DataBindingUtil.inflate<ItemLayerClipPathBinding>(LayoutInflater.from(parent.context), R.layout.item_layer_clip_path, parent, false)
            else -> DataBindingUtil.inflate<ItemLayerAnimationBinding>(LayoutInflater.from(parent.context), R.layout.item_layer_animation, parent, false)
        }

        return ChildrenViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun submitList(items: List<Layer>) {
        mItems = items.toMutableList()
        notifyDataSetChanged()
    }

    fun addItem(item: Layer) {
        mItems.add(item)
        notifyItemInserted(mItems.indexOf(item))
    }


    override fun getItemViewType(position: Int): Int {
        return when(mItems[position]) {
            is Path -> LayerType.PATH.id
            is Group -> LayerType.GROUP.id
            is ClipPath -> LayerType.CLIP_PATH.id
            else -> LayerType.ANIMATION.id
        }
    }

    override fun onBindViewHolder(holder: ChildrenViewHolder, position: Int) {
        when(holder.binding) {
            is ItemLayerPathBinding -> holder.binding.item = mItems[position] as Path
            is ItemLayerGroupBinding -> holder.binding.item = mItems[position] as Group
            is ItemLayerClipPathBinding -> holder.binding.item = mItems[position] as ClipPath
            is ItemLayerAnimationBinding -> holder.binding.item = mItems[position] as Animation
        }
    }

    inner class ChildrenViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onViewMoved(oldPosition: Int, newPosition: Int) {

        val targetItem = mItems[oldPosition]

        if (targetItem is Animation) return

        val item: Layer
        when(targetItem) {
            is Path -> {
                item = Path().apply {
                    name = targetItem.name
                }
            }
            is Group -> {
                item = Group().apply {
                    name = targetItem.name
                }
            }

            else -> {
                item = ClipPath().apply {
                    name = (targetItem as ClipPath).name
                }
            }
        }
        mItems.removeAt(oldPosition)
        mItems.add(newPosition, item)
        notifyItemMoved(oldPosition, newPosition)
    }

    override fun onViewSwiped(position: Int) {
        mItems.removeAt(position)
        notifyItemRemoved(position)
    }


}