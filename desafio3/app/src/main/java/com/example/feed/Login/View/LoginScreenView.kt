package com.example.feed.Login.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.feed.Feed.FeedActivity
import com.example.feed.Login.ViewModel.LoginScreenViewModel
import com.example.feed.R
import com.example.feed.databinding.FragmentLoginScreenBinding


class LoginScreenView : Fragment() {

    private lateinit var binding: FragmentLoginScreenBinding
    private lateinit var LoginViewModel: LoginScreenViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LoginViewModel = ViewModelProvider(this).get(LoginScreenViewModel::class.java)

        binding.apply {
            tvNewUser.setOnClickListener {
                findNavController().navigate(R.id.newUserScreen)
            }
            btLogin.setOnClickListener {
                LoginViewModel.getUser(
                    etLoginUsername.text.toString(),
                    etNewUserPassword.text.toString()
                )
                groupLogin.visibility = View.GONE
                animationLoading.visibility = View.VISIBLE
            }
        }

        LoginViewModel.requestResult.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            if (message == getString(R.string.login_successful)) {
                requireActivity().getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)
                    .edit()
                    .putString("username", LoginViewModel.user)
                    .apply()

                startActivity(Intent(requireActivity(), FeedActivity::class.java))
                activity?.finish()
            } else {
                binding.apply {
                    groupLogin.visibility = View.VISIBLE
                    animationLoading.visibility = View.GONE
                }
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
        binding = FragmentLoginScreenBinding.inflate(layoutInflater)
        return binding.root
    }

}