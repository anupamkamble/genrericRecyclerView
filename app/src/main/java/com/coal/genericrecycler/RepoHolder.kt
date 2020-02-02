package com.coal.genericrecycler

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RepoHolder(var context: Context, itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<GitRepoModel>{

    var userImageView: ImageView
    var repoTitle: TextView
    var created : TextView
    var repoDes : TextView

    init {
        userImageView = itemView.findViewById(R.id.userImage)
        repoTitle = itemView.findViewById(R.id.repoTitle)
        created = itemView.findViewById(R.id.createdRepo)
        repoDes = itemView.findViewById(R.id.repoDescreptopm)
    }

    override fun bind(data: GitRepoModel) {
        Glide.with(context)
            .load(data.imageUrl)
            .into(userImageView)

        repoTitle.text = data.title
        created.text = data.createDtm
        repoDes.text = data.description
    }
}