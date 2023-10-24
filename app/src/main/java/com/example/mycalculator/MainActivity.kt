package com.example.mycalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnClickListener {

    var firstNumber: Double = 0.0
    var secondNumber: Double = 0.0
    var currentOperator: String = ""

    private lateinit var inputTextView: TextView

    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var buttonEquals: Button
    private lateinit var buttonClear: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTextView = findViewById(R.id.inputTextView)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button0 = findViewById(R.id.button0)

        buttonAdd = findViewById(R.id.buttonAdd)
        buttonSub = findViewById(R.id.buttonSubtract)
        buttonMultiply = findViewById(R.id.buttonMultiply)
        buttonDivide = findViewById(R.id.buttonDivide)
        buttonEquals = findViewById(R.id.buttonEquals)
        buttonClear = findViewById(R.id.buttonClear)


        button0.setOnClickListener { onNumberClick("0") }
        button1.setOnClickListener { onNumberClick("1") }
        button2.setOnClickListener { onNumberClick("2") }
        button3.setOnClickListener { onNumberClick("3") }
        button4.setOnClickListener { onNumberClick("4") }
        button5.setOnClickListener { onNumberClick("5") }
        button6.setOnClickListener { onNumberClick("6") }
        button7.setOnClickListener { onNumberClick("7") }
        button8.setOnClickListener { onNumberClick("8") }
        button9.setOnClickListener { onNumberClick("9") }

        buttonAdd.setOnClickListener { onOperatorClick("+") }
        buttonSub.setOnClickListener { onOperatorClick("-") }
        buttonMultiply.setOnClickListener { onOperatorClick("*") }
        buttonDivide.setOnClickListener { onOperatorClick("/") }
        buttonEquals.setOnClickListener { onEqualsClick() }
        buttonClear.setOnClickListener { onClearClick() }

    }

    private fun onNumberClick(number: String) {
        if (currentOperator.isEmpty()) {
            inputTextView.text = (inputTextView.text.toString() + number)
            firstNumber = inputTextView.text.toString().toDouble()
        }
        else {
            inputTextView.text = (inputTextView.text.toString() + number)
            secondNumber = inputTextView.text.toString().split(' ')[2].toDouble()
        }
    }


    private fun onOperatorClick(operator: String) {
        if (currentOperator.isNotEmpty() && inputTextView.text.isNotEmpty()) {
            onEqualsClick()
        }
        currentOperator = operator
        when (currentOperator) {
            "+" -> inputTextView.text = inputTextView.text.toString() + " + "
            "-" -> inputTextView.text = inputTextView.text.toString() + " - "
            "*" -> inputTextView.text = inputTextView.text.toString() + " * "
            "/" -> inputTextView.text = inputTextView.text.toString() + " / "
        }
    }


    private fun onEqualsClick() {
        if (inputTextView.text.isNotEmpty()) {
            when (currentOperator) {
                "+" -> inputTextView.text = (firstNumber + secondNumber).toString()
                "-" -> inputTextView.text = (firstNumber - secondNumber).toString()
                "*" -> inputTextView.text = (firstNumber * secondNumber).toString()
                "/" -> {
                    if (secondNumber != 0.0) {
                        inputTextView.text = (firstNumber / secondNumber).toString()
                    } else {
                        inputTextView.text = "Error"
                    }
                }
            }
            currentOperator = ""
            firstNumber = inputTextView.text.toString().toDouble()
        }
    }

    private fun onClearClick() {
        firstNumber = 0.0
        secondNumber = 0.0
        currentOperator = ""
        inputTextView.text = ""
    }

    override fun onClick(view: View?) {
        view?.let {
            if (it is Button) {
                inputTextView.text = it.text.toString()
            }
        }
    }
}
