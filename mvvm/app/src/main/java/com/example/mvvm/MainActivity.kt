package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setContentView(R.layout.activity_main)
        initViewModel()
        initObservables()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun validateCpf(cpf: String) {
        viewModel.validateCpf(cpf)
    }

    private fun initObservables() {
        viewModel.iscpfValidObservable.observe(this, { isValid ->
            Toast.makeText(this, isValid.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    private fun setupListener() {
        viewBinding.btVallidateCpf.setOnClickListener(){
            validateCpf(viewBinding.etValidateCpf.text.toString())
        }
    }
}


