package com.example.challenge2useacademy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.challenge2useacademy.databinding.FragmentInfoScreenBinding
import com.example.challenge2useacademy.infoScreen.infoScreenViewModel


class infoScreenView : Fragment() {

    private lateinit var infoScreenViewModel: infoScreenViewModel
    private lateinit var binding: FragmentInfoScreenBinding
    private val args: infoScreenViewArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvMovieTitle.text = args.id
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInfoScreenBinding.inflate(layoutInflater)
        activity?.findViewById<ImageView>(R.id.b_back_toolbar)?.isVisible = true
        return binding.root
    }

    fun initViewModel(){
        infoScreenViewModel = ViewModelProvider(this).get(infoScreenViewModel::class.java)
    }



}