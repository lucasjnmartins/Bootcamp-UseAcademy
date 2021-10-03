package com.example.challenge2useacademy.Recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2useacademy.Data.Movies
import com.example.challenge2useacademy.databinding.ItemListsLayoutBinding
import com.squareup.picasso.Picasso

class RecyclerViewAdapterAction(
    private val listAction: ArrayList<Movies>,
    private val function: (movie: Movies) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapterAction.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = listAction[position].title
        Picasso.get().load(listAction[position].image).into(holder.image)
        holder.itemView.setOnClickListener{
            function(listAction[position])
        }
    }

    override fun getItemCount(): Int {
        return listAction.size
    }

    fun update(movies: List<Movies>) {
        listAction.clear()
        listAction.addAll(movies)
        notifyDataSetChanged()
    }

    class ViewHolder(view: ItemListsLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        val text = view.tvRecyclerList
        val image = view.ivRecyclerList
    }

}