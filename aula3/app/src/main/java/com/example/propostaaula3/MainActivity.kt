package com.example.propostaaula3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var editTextReal: EditText? = null
    private var buttonConvert: Button? = null
    private var textResult: TextView? = null
    private var radioDolar: RadioButton? = null
    private var radioEuro: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        clickEvents()
    }

    private fun setupView() {
        editTextReal = findViewById(R.id.edit_text_real)
        buttonConvert = findViewById(R.id.button_convert)
        textResult = findViewById(R.id.text_view_result)
        radioDolar = findViewById(R.id.radio_button_dolar)
        radioEuro = findViewById(R.id.radio_button_euro)
    }

    private fun clickEvents() {
        buttonConvert?.setOnClickListener {
            if (radioDolar?.isChecked == true) {
                convertReal(editTextReal?.text.toString().toDouble(), DOLAR, true)
            } else if (radioEuro?.isChecked == true) {
                convertReal(editTextReal?.text.toString().toDouble(), EURO, false)
            }
        }
    }

    private fun convertReal(value: Double, weight: Double, flag: Boolean) {
        if (flag) {
            textResult?.text = "O valor de ${value} reais em  dolars é ${value / weight}"
        } else {
            textResult?.text = "O valor de ${value} reais em  euros é ${value / weight}"
        }
    }

    companion object {
        const val DOLAR = 5.26
        const val EURO = 6.19
    }
}

