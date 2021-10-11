package com.example.feed.Feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.feed.R
import com.example.feed.databinding.ActivityFeedBinding

class FeedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.nav_host_feed_fragment)

        binding.bottombar.findViewById<LinearLayout>(R.id.bb_feed).setOnClickListener {
            navController.navigate(R.id.feedScreen)
        }
        binding.bottombar.findViewById<LinearLayout>(R.id.bb_post).setOnClickListener {
            navController.navigate(R.id.postScreen)
        }
        binding.bottombar.findViewById<LinearLayout>(R.id.bb_profile).setOnClickListener {
            navController.navigate(R.id.profileScreen)
        }
    }
}