package com.minhchi.basemydocument.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.minhchi.basemydocument.model.RepositoryData

class BaseVH(view: View) : RecyclerView.ViewHolder(view) {
    companion object {

        val itemCallback
            get() = object : DiffUtil.ItemCallback<RepositoryData>() {
                override fun areItemsTheSame(
                    oldItem: RepositoryData,
                    newItem: RepositoryData
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: RepositoryData,
                    newItem: RepositoryData
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}