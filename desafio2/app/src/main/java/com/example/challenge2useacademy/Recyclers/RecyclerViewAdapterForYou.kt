package com.example.challenge2useacademy.Recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2useacademy.movies.Movies
import com.example.challenge2useacademy.databinding.ItemListsLayoutBinding
import com.squareup.picasso.Picasso

class RecyclerViewAdapterForYou(
    private val listForYou: ArrayList<Movies>,
    private val function: (movie: Movies) -> Unit
        ):
    RecyclerView.Adapter<RecyclerViewAdapterForYou.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = listForYou[position].title
        Picasso.get().load(listForYou[position].image).into(holder.image)
        holder.itemView.setOnClickListener {
            function(listForYou[position])
        }
    }

    override fun getItemCount(): Int {
        return listForYou.size
    }

    fun update(movies: List<Movies>) {
        listForYou.clear()
        listForYou.addAll(movies)
        notifyDataSetChanged()
    }

    class ViewHolder(view: ItemListsLayoutBinding): RecyclerView.ViewHolder(view.root) {
        val text = view.tvRecyclerList
        val image = view.ivRecyclerList
    }
}