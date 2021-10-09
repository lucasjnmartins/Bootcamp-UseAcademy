package com.example.feed.Login

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.feed.MainActivity
import com.example.feed.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginScreenViewModel(app: Application): AndroidViewModel(app) {
    val db = Firebase.firestore
    val requestResult: MutableLiveData<String> = MutableLiveData<String>()

    fun getUser(user: String, pass: String) {
        db.collection("users").get().addOnSuccessListener { users ->
            var isnt: Boolean = true
            for(person in users) {
                if(person.data["username"].toString() == user) {
                    isnt = false
                    if(person.data["password"].toString() == pass) {
                        requestResult.value = getApplication<Application>().getString(R.string.login_successful)
                    }else{
                        requestResult.value = "Senha incorreta."
                    }
                }
            }

            if(isnt) {
                requestResult.value = "Usuário não existe"
            }
        }.addOnFailureListener {
           requestResult.value = "Falha na requisição."
        }
    }
}