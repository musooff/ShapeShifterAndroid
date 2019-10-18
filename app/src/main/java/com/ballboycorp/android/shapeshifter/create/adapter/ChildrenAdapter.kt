package com.ballboycorp.android.shapeshifter.create.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.android.shapeshifter.R
import com.ballboycorp.android.shapeshifter.create.model.*
import com.ballboycorp.android.shapeshifter.databinding.ItemChildAnimationBinding
import com.ballboycorp.android.shapeshifter.databinding.ItemChildClipPathBinding
import com.ballboycorp.android.shapeshifter.databinding.ItemChildGroupBinding
import com.ballboycorp.android.shapeshifter.databinding.ItemChildPathBinding

class ChildrenAdapter: RecyclerView.Adapter<ChildrenAdapter.ChildrenViewHolder>() {

    private var mItems = mutableListOf<Child>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenViewHolder {
        val binding = when(viewType) {
            ChildType.PATH.id -> DataBindingUtil.inflate<ItemChildPathBinding>(LayoutInflater.from(parent.context), R.layout.item_child_path, parent, false)
            ChildType.GROUP.id -> DataBindingUtil.inflate<ItemChildGroupBinding>(LayoutInflater.from(parent.context), R.layout.item_child_group, parent, false)
            ChildType.CLIP_PATH.id -> DataBindingUtil.inflate<ItemChildClipPathBinding>(LayoutInflater.from(parent.context), R.layout.item_child_clip_path, parent, false)
            else -> DataBindingUtil.inflate<ItemChildAnimationBinding>(LayoutInflater.from(parent.context), R.layout.item_child_animation, parent, false)
        }

        return ChildrenViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun submitList(items: List<Child>) {
        mItems = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when(mItems[position]) {
            is Path -> ChildType.PATH.id
            is Group -> ChildType.GROUP.id
            is ClipPath -> ChildType.CLIP_PATH.id
            else -> ChildType.ANIMATION.id
        }
    }

    override fun onBindViewHolder(holder: ChildrenViewHolder, position: Int) {
        when(holder.binding) {
            is ItemChildPathBinding -> holder.binding.item = mItems[position] as Path
            is ItemChildGroupBinding -> holder.binding.item = mItems[position] as Group
            is ItemChildClipPathBinding -> holder.binding.item = mItems[position] as ClipPath
            is ItemChildAnimationBinding -> holder.binding.item = mItems[position] as Animation
        }
    }

    inner class ChildrenViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}