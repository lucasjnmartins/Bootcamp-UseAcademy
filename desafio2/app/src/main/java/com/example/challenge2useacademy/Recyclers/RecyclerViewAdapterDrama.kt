package com.example.challenge2useacademy.Recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2useacademy.Data.Movies
import com.example.challenge2useacademy.databinding.ItemListsLayoutBinding
import com.squareup.picasso.Picasso

class RecyclerViewAdapterDrama (
    private val listDrama: ArrayList<Movies>,
    private val function: (movie: Movies) -> Unit
        )
    : RecyclerView.Adapter<RecyclerViewAdapterDrama.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = listDrama[position].title
        Picasso.get().load(listDrama[position].image).into(holder.image)
        holder.itemView.setOnClickListener {
            function(listDrama[position])
        }
    }

    override fun getItemCount(): Int {
        return listDrama.size
    }

    fun update(movies: List<Movies>) {
        listDrama.clear()
        listDrama.addAll(movies)
        notifyDataSetChanged()
    }

    class ViewHolder(view: ItemListsLayoutBinding): RecyclerView.ViewHolder(view.root){
        val text = view.tvRecyclerList
        val image = view.ivRecyclerList
    }
}