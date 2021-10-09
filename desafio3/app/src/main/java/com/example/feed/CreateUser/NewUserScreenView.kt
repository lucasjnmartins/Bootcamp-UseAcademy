package com.example.feed.CreateUser

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.feed.R
import com.example.feed.Repository.User
import com.example.feed.databinding.FragmentNewUserScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.StringBuilder


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
            } else {
                Toast.makeText(context, "Não foi possível criar usuário", Toast.LENGTH_LONG).show()
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