package com.minhchi.basemydocument.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.minhchi.basemydocument.model.RepositoryData
import com.minhchi.basemydocument.R
import com.minhchi.basemydocument.databinding.ReporitoryListRowBinding

class MovieAdapter : ListAdapter<RepositoryData, BaseVH>(BaseVH.itemCallback) {
    var onItemClick: ((RepositoryData) -> Unit)? = null

    //var onItemLongClick: ((MovieDBO, Int) -> Unit)? = null
    var onItemLongClick: ((RepositoryData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.reporitory_list_row, parent, false)
        return BaseVH(view)
    }

    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        val vb = ReporitoryListRowBinding.bind(holder.itemView)
        val data = getItem(position)
        vb.tvName.text = data.name
        vb.tvDesc.text = data.description
        //val urlImage = "https://image.tmdb.org/t/p/w500${movie.poster}"
        Glide.with(holder.itemView.context).load(data.owner?.avatar_url)
            .into(vb.imageAvatarUrl)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(data)
        }

        holder.itemView.setOnLongClickListener {
            onItemLongClick?.invoke(data)//invoke(movie,position)

            true
        }
    }

    fun getMovie(position: Int): RepositoryData {
        return getItem(position);
    }
}