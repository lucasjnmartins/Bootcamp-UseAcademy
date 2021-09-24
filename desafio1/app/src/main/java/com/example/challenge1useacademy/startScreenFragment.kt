package com.example.challenge1useacademy

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toolbar
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.challenge1useacademy.databinding.ActivityMainBinding
import com.example.challenge1useacademy.databinding.FragmentStartScreenBinding

class startScreenFragment : Fragment() {

    private lateinit var binding: FragmentStartScreenBinding

    val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickButton()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStartScreenBinding.inflate(layoutInflater)
        activity?.findViewById<ImageView>(R.id.b_back)?.isVisible = false
        return binding.root
    }

    fun clickButton() {
        binding.apply {
            bNext.setOnClickListener {
                findNavController().navigate(R.id.questionScreenFragment)
            }
        }
    }


}