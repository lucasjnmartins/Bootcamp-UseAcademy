package com.example.feed.Feed.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.PostsRepository.Comment
import com.example.feed.databinding.ItemLayoutCommentBinding

class RecyclerViewAdapterFeed(
    private val listComment: ArrayList<Comment>
)
    :RecyclerView.Adapter<RecyclerViewAdapterFeed.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.profileName.text = listComment[position].name
        holder.text.text = listComment[position].text
    }

    override fun getItemCount(): Int {
        return listComment.size
    }

    class ViewHolder(view: ItemLayoutCommentBinding): RecyclerView.ViewHolder(view.root) {
        val profileImage = view.icCommentProfile
        val profileName = view.tvCommentProfile
        val text = view.tvCommentText
    }
}