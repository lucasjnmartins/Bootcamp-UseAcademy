package com.example.feed.Feed.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.feed.R
import com.example.feed.databinding.FragmentPostScreenBinding


class PostScreenView : Fragment() {

    private lateinit var binding: FragmentPostScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<ImageView>(R.id.b_back_toolbar)?.apply {
            visibility = View.VISIBLE
            isClickable = true
        }

        activity?.findViewById<ImageView>(R.id.b_back_toolbar)?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPostScreenBinding.inflate(layoutInflater)


        return binding.root
    }

}