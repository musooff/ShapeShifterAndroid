package com.ballboycorp.android.shapeshifter.create.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView

class DragHelper(private val contract: ActionCompletionContract): ItemTouchHelper.Callback()  {


    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = UP or DOWN
        val swipeFlags = LEFT or RIGHT
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        contract.onViewMoved(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        contract.onViewSwiped(viewHolder.adapterPosition)
    }

    interface ActionCompletionContract {
        fun onViewMoved(oldPosition: Int, newPosition: Int)

        fun onViewSwiped(position: Int)
    }
}