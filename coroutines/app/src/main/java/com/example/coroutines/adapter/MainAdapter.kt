package com.example.coroutines.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var stringList: MutableList<String> = arrayListOf()

    class MainViewHolder() : RecyclerView.ViewHolder(view.root) {

        fun bind (){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(stringList[position])
    }

    override fun getItemCount(): Int {
        stringList.size
    }
}