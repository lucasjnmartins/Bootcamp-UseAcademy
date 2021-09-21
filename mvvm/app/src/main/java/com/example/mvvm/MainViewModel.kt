package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val cpfManager: cpfManager = cpfManager()
    val iscpfValidObservable: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

    fun validateCpf (cpf: String) {
        iscpfValidObservable.value = cpfManager.isValid(cpf)
    }

    private fun isEmail(info: String) : Boolean = info.length > 11
}