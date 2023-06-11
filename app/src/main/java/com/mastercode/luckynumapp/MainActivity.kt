package com.mastercode.luckynumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var inputNameTextView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        addListener()
    }

    private fun initViews() {
        inputNameTextView = findViewById(R.id.inputName)
        button = findViewById(R.id.btn)
    }

    private fun addListener() {
        button.setOnClickListener(){
            var name = inputNameTextView.text

            //explicit Intents
            var i: Intent = Intent(this, LuckyNumberActivity::class.java)
            i.putExtra("userName", name)

            startActivity(i)
        }
    }
}