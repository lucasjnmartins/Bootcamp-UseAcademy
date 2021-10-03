package com.example.challenge2useacademy.Recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2useacademy.Data.Movies
import com.example.challenge2useacademy.databinding.ItemSeeMoreLayoutBinding
import com.squareup.picasso.Picasso

class RecyclerViewAdapterSeeMore(
    private val list: ArrayList<Movies>,
    private val function: (movie: Movies) -> Unit
    ):
    RecyclerView.Adapter<RecyclerViewAdapterSeeMore.ViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSeeMoreLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = list[position].title
        Picasso.get().load(list[position].image).into(holder.image)
        holder.itemView.setOnClickListener {
            function(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun update(movies: List<Movies>) {
        list.clear()
        list.addAll(movies)
        notifyDataSetChanged()
    }

    class ViewHolder(view: ItemSeeMoreLayoutBinding): RecyclerView.ViewHolder(view.root) {
        val text = view.tvItemSeeMore
        val image = view.ivItemSeeMore
    }
}