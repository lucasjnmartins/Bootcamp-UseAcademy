package com.example.feed.Feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feed.R
import com.example.feed.databinding.FragmentFeedScreenBinding
import com.example.feed.databinding.FragmentLoginScreenBinding


class FeedScreenView : Fragment() {

    private lateinit var binding: FragmentFeedScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFeedScreenBinding.inflate(layoutInflater)
        return binding.root
    }

}