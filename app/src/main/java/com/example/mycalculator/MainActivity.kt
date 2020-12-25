package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.attribute.AclEntry

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private var firstvariable:Double = 0.0
    private var secondvariable:Double = 0.0
    private var operation =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        B0.setOnClickListener(this)
        B1.setOnClickListener(this)
        B2.setOnClickListener(this)
        B3.setOnClickListener(this)
        B4.setOnClickListener(this)
        B5.setOnClickListener(this)
        B6.setOnClickListener(this)
        B7.setOnClickListener(this)
        B8.setOnClickListener(this)
        B9.setOnClickListener(this)

        dotB.setOnClickListener() {
            if (resultTextView.text.isNotEmpty() && "." !in resultTextView.text) {
                dotB.isClickable = true
                resultTextView.text = resultTextView.text.toString() + "."

            }
        }

        deleteButton.setOnLongClickListener() {
            if (resultTextView.text.isNotEmpty()) {
                resultTextView.text = ""

            }
            true
        }

    }
        fun equal(view: View) {
            var value = resultTextView.text.toString()
            var value2 = firstvariable.toString()
            if (value.isNotEmpty() && value2.isNotEmpty()) {
                secondvariable = value.toDouble()

                var result: Double = 0.0
                if (operation == ":") {
                    if (secondvariable == 0.0) {
                        Toast.makeText(this, "Divided by zero!", Toast.LENGTH_SHORT).show()
                        resultTextView.text=" "
                    }else {result = firstvariable / secondvariable
                        resultTextView.text = result.toString()
                    }
                } else if (operation == "+") {
                    result = firstvariable + secondvariable
                    resultTextView.text = result.toString()
                } else if (operation == "-") {
                    result = firstvariable - secondvariable
                    resultTextView.text = result.toString()
                } else if (operation == "x") {
                    result = firstvariable * secondvariable
                    resultTextView.text = result.toString()
                }

                resultTextView.text = result.toString()
            }

        }

        fun delete(view: View) {
            val value = resultTextView.text.toString()
            if (value.isNotEmpty())
                resultTextView.text = value.substring(0, value.length - 1)

        }

        fun divide(view: View) {
            var value = resultTextView.text.toString()
            if (value.isNotEmpty()) {
                operation = ":"
                firstvariable = value.toDouble()
                resultTextView.text = ""
            }
        }
        fun minus(view: View) {
            var value = resultTextView.text.toString()
            if (value.isNotEmpty())
                operation = "-"
            firstvariable = value.toDouble()
            resultTextView.text = ""

        }

        fun plus(view: View) {
            var value = resultTextView.text.toString()
            if (value.isNotEmpty())
                operation = "+"
            firstvariable = value.toDouble()
            resultTextView.text = ""
        }

        fun multiplication(view: View) {
            var value = resultTextView.text.toString()
            if (value.isNotEmpty())
                operation = "x"
            firstvariable = value.toDouble()
            resultTextView.text = ""
        }


        override fun onClick(v: View?) {
            val button = v as Button
            resultTextView.text = "${resultTextView.text}${button.text}"
        }
    }