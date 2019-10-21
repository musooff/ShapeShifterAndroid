package com.ballboycorp.android.shapeshifter.create.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.android.shapeshifter.R
import com.ballboycorp.android.shapeshifter.create.model.Animation
import com.ballboycorp.android.shapeshifter.databinding.ItemLayerAnimationDetailsBinding

/**
 * Created by musooff on 2019-10-21.
 */

class AnimationAdapter: RecyclerView.Adapter<AnimationAdapter.AnimationViewHolder>() {

    private var mItems = mutableListOf<Animation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimationViewHolder {
        val binding = DataBindingUtil.inflate<ItemLayerAnimationDetailsBinding>(LayoutInflater.from(parent.context), R.layout.item_layer_animation_details, parent, false)
        return AnimationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun submitList(items: List<Animation>) {
        mItems = items as MutableList<Animation>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AnimationViewHolder, position: Int) {
    }

    inner class AnimationViewHolder(val binding: ItemLayerAnimationDetailsBinding): RecyclerView.ViewHolder(binding.root)
}