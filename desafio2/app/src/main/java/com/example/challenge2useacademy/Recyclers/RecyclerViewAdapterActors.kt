package com.example.challenge2useacademy.Recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2useacademy.databinding.ItemActorsLayoutBinding
import com.example.challenge2useacademy.movies.Actor
import com.example.challenge2useacademy.movies.Movies
import com.squareup.picasso.Picasso

class RecyclerViewAdapterActors(
    private val listActors: ArrayList<Actor>
)
    :RecyclerView.Adapter<RecyclerViewAdapterActors.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemActorsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = listActors[position].name
        Picasso.get().load(listActors[position].image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return listActors.size
    }

    fun update(actors: List<Actor>) {
        listActors.clear()
        listActors.addAll(actors)
        notifyDataSetChanged()
    }

    class ViewHolder(view: ItemActorsLayoutBinding): RecyclerView.ViewHolder(view.root) {
        val text = view.tvItemActors
        val image = view.icItemActors
    }
}