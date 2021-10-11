package com.example.feed.Feed.View

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.feed.R
import com.example.feed.databinding.FragmentProfileScreenBinding


class ProfileScreenView : Fragment() {

    private lateinit var binding: FragmentProfileScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<ImageView>(R.id.b_back_toolbar)?.visibility = View.GONE

        activity?.findViewById<ImageView>(R.id.bb_iv_feed)?.setColorFilter(R.color.bottom_bar_black)
        activity?.findViewById<TextView>(R.id.bb_tv_feed)?.setTextColor(ContextCompat.getColor(requireContext(), R.color.bottom_bar_black))
        activity?.findViewById<ImageView>(R.id.bb_iv_profile)?.setColorFilter(R.color.primary_color_yellow)
        activity?.findViewById<TextView>(R.id.bb_tv_profile)?.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary_color_yellow))


        activity?.findViewById<LinearLayout>(R.id.bb_feed)?.setOnClickListener {
            findNavController().navigate(R.id.feedScreen)
        }
        activity?.findViewById<LinearLayout>(R.id.bb_post)?.setOnClickListener {
            findNavController().navigate(R.id.postScreen)
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
        binding = FragmentProfileScreenBinding.inflate(layoutInflater)
        return binding.root
    }

}