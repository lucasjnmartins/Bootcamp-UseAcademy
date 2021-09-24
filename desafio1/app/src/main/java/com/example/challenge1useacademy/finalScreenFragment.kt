package com.example.challenge1useacademy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions
import com.example.challenge1useacademy.databinding.FragmentFinalScreenBinding


class finalScreenFragment : Fragment() {

    private lateinit var binding: FragmentFinalScreenBinding
    private val args: finalScreenFragmentArgs by navArgs()


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
        binding.tvScore.text = String.format(getString(R.string._acertos), args.score)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFinalScreenBinding.inflate(layoutInflater)
        activity?.findViewById<ImageView>(R.id.b_back)?.isVisible = false

        return binding.root
    }

    fun clickButton() {
        binding.apply {
            bTryAgain.setOnClickListener {
                findNavController().navigate(R.id.startScreenFragment)
            }
        }
    }

}