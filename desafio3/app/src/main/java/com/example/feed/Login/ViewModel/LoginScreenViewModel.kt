package com.example.feed.Login.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.feed.R
import com.example.feed.Repository.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginScreenViewModel(app: Application) : AndroidViewModel(app) {
    val db = Firebase.firestore
    val requestResult: MutableLiveData<String> = MutableLiveData<String>()
    lateinit var user:  String

    fun getUser(username: String, pass: String) {
        db.collection("users").get().addOnSuccessListener { users ->
            var isnt: Boolean = true
            for (person in users) {
                if (person.data["username"].toString() == username) {
                    isnt = false
                    if (person.data["password"].toString() == pass) {
                        user = person.data["username"].toString()
                        requestResult.value = getApplication<Application>().getString(R.string.login_successful)
                    } else {
                        requestResult.value = "Senha incorreta."
                    }
                }
            }

            if (isnt) {
                requestResult.value = "Usuário não existe"
            }
        }.addOnFailureListener {
            requestResult.value = "Falha na requisição."
        }
    }
}