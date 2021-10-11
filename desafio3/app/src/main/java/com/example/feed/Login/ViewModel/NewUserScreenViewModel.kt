package com.example.feed.Login.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feed.Repository.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class NewUserScreenViewModel: ViewModel() {
    val db = Firebase.firestore
    var requestResult: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    var requestMessage: MutableLiveData<String> = MutableLiveData<String>()

    fun createUser(user: User) {
        var compare: Boolean
        db.collection("users").get().addOnSuccessListener { users ->
            compare = true

            for(person in users) {
               if (person.data["username"].toString() == user.username) {
                   compare = false
               }
            }

            if(compare){
                db.collection("users").add(user).addOnSuccessListener {
                    requestResult.value = true
                    requestMessage.value = it.toString()
                }.addOnFailureListener {
                    requestResult.value = false
                    requestMessage.value = it.toString()
                }
            } else {
                requestResult.value = false
                requestMessage.value = "Nome de usuário já existe."
            }
        }
    }
}