package com.example.challenge2useacademy.startScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge2useacademy.R
import com.example.challenge2useacademy.Recyclers.RecyclerViewAdapterAction
import com.example.challenge2useacademy.Recyclers.RecyclerViewAdapterDrama
import com.example.challenge2useacademy.Recyclers.RecyclerViewAdapterForYou
import com.example.challenge2useacademy.databinding.FragmentStartScreenBinding
import com.example.challenge2useacademy.movies.Movies
import com.squareup.picasso.Picasso


class startScreen() : Fragment() {

    private lateinit var  startViewModel: startScreenViewModel
    private lateinit var binding: FragmentStartScreenBinding
    lateinit var moviesAdapterForYou: RecyclerViewAdapterForYou
    lateinit var moviesAdapterAction: RecyclerViewAdapterAction
    lateinit var moviesAdapterDrama: RecyclerViewAdapterDrama

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startViewModel = ViewModelProvider(this).get(startScreenViewModel::class.java)
        moviesAdapterForYou = RecyclerViewAdapterForYou(arrayListOf()) { movie ->
            navigateToInfoScreen(movie)
        }
        moviesAdapterAction = RecyclerViewAdapterAction(arrayListOf()) { movie ->
            navigateToInfoScreen(movie)
        }
        moviesAdapterDrama = RecyclerViewAdapterDrama(arrayListOf()) { movie ->
            navigateToInfoScreen(movie)
        }

        binding.apply {
            rvForYou.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = moviesAdapterForYou
            }
            rvAction.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = moviesAdapterAction
            }
            rvDrama.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = moviesAdapterDrama
            }

            tvSeeMoreForYou.setOnClickListener {
                findNavController().navigate(startScreenDirections.actionStartScreenToSeeMore(getString(R.string.for_you)))
            }
            tvSeeMoreAction.setOnClickListener {
                findNavController().navigate(startScreenDirections.actionStartScreenToSeeMore(getString(R.string.action)))
            }
            tvSeeMoreDrama.setOnClickListener {
                findNavController().navigate(startScreenDirections.actionStartScreenToSeeMore(getString(R.string.drama)))
            }
            clRelease.setOnClickListener {
                startViewModel.release.value?.let { it1 -> navigateToInfoScreen(it1) }
            }
        }

        startViewModel.fetchMovies()

        startViewModel.movieListForYou.observe(viewLifecycleOwner, Observer {movies ->
            movies?.let {
                moviesAdapterForYou.update(it)
            }
        })
        startViewModel.movieListAction.observe(viewLifecycleOwner, Observer {
            it.let {
                moviesAdapterAction.update(it)
            }
        })
        startViewModel.movieListDrama.observe(viewLifecycleOwner, Observer {
            it.let {
                moviesAdapterDrama.update(it)
            }
        })
        startViewModel.release.observe(viewLifecycleOwner, Observer {
            binding.apply {
                Picasso.get().load(startViewModel.release.value?.image).into(ivRelease)
                tvTitleRelease.text = startViewModel.release.value?.title
                tvActorsRelease.text = startViewModel.release.value?.crew
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
        binding = FragmentStartScreenBinding.inflate(layoutInflater)
        activity?.findViewById<ImageView>(R.id.b_back_toolbar)?.isVisible = false
        activity?.findViewById<TextView>(R.id.tv_toolbar)?.text = getString(R.string.title)
        return binding.root
    }

    private fun navigateToInfoScreen(movie: Movies): Unit {
        findNavController().navigate(startScreenDirections.actionStartScreenToInfoScreen(movie.id))
    }

}