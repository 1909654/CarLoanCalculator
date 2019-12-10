package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener { calLoan() }
        buttonReset.setOnClickListener { resetBut() }
    }

    private fun calLoan() {
        val carPrice : EditText = findViewById(R.id.editTextCarPrice)
        val price : Double = carPrice.text.toString().toDouble()

        val downPay : EditText = findViewById(R.id.editTextDownPayment)
        val dpay : Double = downPay.text.toString().toDouble()

        val interestRate : EditText = findViewById(R.id.editTextInterestRate)
        val interest : Double = interestRate.text.toString().toDouble()

        val loanPeriod : EditText = findViewById(R.id.editTextLoanPeriod)
        val loan : Double = loanPeriod.text.toString().toDouble()

        val calL : Double = price - dpay
        val calI : Double = calL * interest * loan
        val calMP : Double = (calL + calI) / loan / 12

        calculateLoan.text = calL.toString()
        calculateInterest.text = calI.toString()
        calculateMP.text = calMP.toString()
    }

    private fun resetBut () {
        val carPrice : EditText = findViewById(R.id.editTextCarPrice)
        val downPay : EditText = findViewById(R.id.editTextDownPayment)
        val interestRate : EditText = findViewById(R.id.editTextInterestRate)
        val loanPeriod : EditText = findViewById(R.id.editTextLoanPeriod)
        val calculateLoan : TextView = findViewById(R.id.calculateLoan)
        val calculateInterest : TextView = findViewById(R.id.calculateInterest)
        val calculateMP : TextView = findViewById(R.id.calculateMP)

        carPrice.text.clear()
        downPay.text.clear()
        interestRate.text.clear()
        loanPeriod.text.clear()
        calculateLoan.text = ""
        calculateInterest.text = ""
        calculateMP.text = ""
    }
}
