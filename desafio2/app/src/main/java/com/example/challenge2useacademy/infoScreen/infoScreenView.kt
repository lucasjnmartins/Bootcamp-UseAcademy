package com.example.challenge2useacademy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge2useacademy.Recyclers.RecyclerViewAdapterActors
import com.example.challenge2useacademy.databinding.FragmentInfoScreenBinding
import com.example.challenge2useacademy.infoScreen.infoScreenViewModel
import com.example.challenge2useacademy.movies.Movies
import com.example.challenge2useacademy.startScreen.startScreenDirections
import com.squareup.picasso.Picasso


class infoScreenView : Fragment() {

    private lateinit var infoViewModel: infoScreenViewModel
    private lateinit var binding: FragmentInfoScreenBinding
    private val args: infoScreenViewArgs by navArgs()
    lateinit var actorsAdapter: RecyclerViewAdapterActors

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        actorsAdapter = RecyclerViewAdapterActors(arrayListOf())

        activity?.findViewById<ImageView>(R.id.b_back_toolbar)?.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.rvActors.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = actorsAdapter
        }

        infoViewModel.fetchDetailMovies(args.id)

        infoViewModel.details.observe(viewLifecycleOwner, Observer {
            binding.apply {
                Picasso.get().load(it.image).into(ivMovie)
                tvMovieTitle.text = it.title
                tvMovieActors.text = it.stars
                tvResumeText.text = it.plot
                actorsAdapter.update(it.actorList)
            }
        })
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
        activity?.apply {
            findViewById<ImageView>(R.id.b_back_toolbar)?.isVisible = true
            findViewById<ImageView>(R.id.b_back_toolbar)?.isClickable = true
            findViewById<TextView>(R.id.tv_toolbar)?.text = getString(R.string.title_info_screen)
        }
        return binding.root
    }

    fun initViewModel() {
        infoViewModel = ViewModelProvider(this).get(infoScreenViewModel::class.java)
    }


}