package com.example.feed.Login.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.feed.Login.ViewModel.NewUserScreenViewModel
import com.example.feed.R
import com.example.feed.Repository.User
import com.example.feed.databinding.FragmentNewUserScreenBinding


class NewUserScreenView : Fragment() {

    private lateinit var binding: FragmentNewUserScreenBinding
    private lateinit var NewUserViewModel: NewUserScreenViewModel
    private lateinit var user: User
    private var bBackToolbar: ImageView? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NewUserViewModel = ViewModelProvider(this).get(NewUserScreenViewModel::class.java)

        binding.apply {
            btAddUser.setOnClickListener {
                user = User(
                    etNewUserName.text.toString(),
                    etNewUserLastName.text.toString(),
                    etNewUserUsername.text.toString(),
                    etNewUserPassword.text.toString()
                    )
                if((user.name != "") || (user.lastName != "") || (user.username != "") || (user.password != "")){
                    NewUserViewModel.createUser(user)
                    groupNewUser.visibility = View.GONE
                    animationLoading.visibility = View.VISIBLE
                }else{
                    Toast.makeText(context, "Existem campos vazios", Toast.LENGTH_SHORT).show()
                }
            }
        }
        bBackToolbar?.setOnClickListener {
            findNavController().popBackStack()
        }

        NewUserViewModel.requestResult.observe(viewLifecycleOwner, Observer {
            if(it) {
                Toast.makeText(context, "Usuário criado", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.loginScreen)
            } else {
                Toast.makeText(context, "Não foi possível criar usuário", Toast.LENGTH_LONG).show()
            }
            binding.apply {
                groupNewUser.visibility = View.VISIBLE
                animationLoading.visibility = View.GONE
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
        binding = FragmentNewUserScreenBinding.inflate(layoutInflater)
        bBackToolbar = activity?.findViewById<ImageView>(R.id.b_back_toolbar)

        bBackToolbar?.isVisible = true
        bBackToolbar?.isClickable = true

        return binding.root
    }

}