package com.infendro.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun addToEquation(view:android.view.View){
        val button = view as Button
        equation.setText(equation.text.toString()+button.text)
    }

    fun clearEquation(view:android.view.View){
        equation.setText("")
    }

    fun calcEquation(view:android.view.View){
        equation.setText(PostfixCalculator(PostFixConverter(equation.text.toString()).getPostfixAsList()).getResult().toString())
        //equation.setText(PostFixConverter(equation.text.toString()).getPostfixExpression())
    }

}