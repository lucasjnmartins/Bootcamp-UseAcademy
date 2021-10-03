package com.example.challenge2useacademy

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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.challenge2useacademy.Data.Movies
import com.example.challenge2useacademy.Recyclers.RecyclerViewAdapterSeeMore
import com.example.challenge2useacademy.databinding.FragmentSeeMoreBinding
import com.example.challenge2useacademy.seeMoreView.seeMoreViewModel


class seeMore : Fragment() {

    private lateinit var seeMoreViewModel: seeMoreViewModel
    private lateinit var binding: FragmentSeeMoreBinding
    lateinit var recycler: RecyclerViewAdapterSeeMore
    private val args: seeMoreArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvSeeMore.text = args.genre
        seeMoreViewModel = ViewModelProvider(this).get(com.example.challenge2useacademy.seeMoreView.seeMoreViewModel::class.java)
        recycler = RecyclerViewAdapterSeeMore(arrayListOf()) { movie ->
            navigateToInfoScreen(movie)
        }

        binding.apply {
            rvSeeMore.apply {
                layoutManager = GridLayoutManager(requireContext(), 2)
                adapter = recycler
            }
        }
        activity?.findViewById<ImageView>(R.id.b_back_toolbar)?.setOnClickListener {
            findNavController().popBackStack()
        }

        seeMoreViewModel.fetchMovies(this)

        seeMoreViewModel.movieListForYou.observe(viewLifecycleOwner, Observer {
            if(args.genre == getString(R.string.for_you)) {
                recycler.update(it)
            }
        })
        seeMoreViewModel.movieListAction.observe(viewLifecycleOwner, Observer {
            if(args.genre == getString(R.string.action)) {
                recycler.update(it)
            }
        })
        seeMoreViewModel.movieListDrama.observe(viewLifecycleOwner, Observer {
            if(args.genre == getString(R.string.drama)) {
                recycler.update(it)
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
        binding = FragmentSeeMoreBinding.inflate(layoutInflater)
        activity?.apply {
            findViewById<ImageView>(R.id.b_back_toolbar)?.isVisible = true
            findViewById<ImageView>(R.id.b_back_toolbar)?.isClickable = true
            findViewById<TextView>(R.id.tv_toolbar)?.text = getString(R.string.see_more)
        }
        return binding.root
    }

    private fun navigateToInfoScreen(movie: Movies): Unit {
        findNavController().navigate(seeMoreDirections.actionSeeMoreToInfoScreen(movie.id))
    }
}