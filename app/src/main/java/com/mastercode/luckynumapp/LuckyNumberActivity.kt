package com.mastercode.luckynumapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var luckyNumberTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)
        initViews()
        addListener()
        welcomeUser()
        showUserLuckyNumber()
    }

    private fun initViews() {
        luckyNumberTextView = findViewById(R.id.luckNumText)
        button = findViewById(R.id.shareLuck)
    }

    private fun addListener() {
        button.setOnClickListener(){
            var receiveUserName = receiveUserName()
            var luckyNumber = luckyNumberTextView.text.toString()
            shareData(receiveUserName, luckyNumber)
        }
    }

    private fun shareData(username: String,luckyNum: String){
        var i: Intent = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        i.putExtra(Intent.EXTRA_TEXT, "The lucky number is $luckyNum")
        startActivity(i)
    }

    private fun randomNumberGenerator(): Int{
        var random = Random.nextInt(1000)
        return random
    }

    private fun welcomeUser() {
        var username = receiveUserName()
        Toast.makeText(this, "Hello $username", Toast.LENGTH_LONG).show()
    }

    private fun receiveUserName(): String {
        var bundle: Bundle? = intent.extras
        var username = bundle?.get("userName")
        return username.toString()
    }

    private fun showUserLuckyNumber(){
        var randomNumberGenerator = randomNumberGenerator()
        luckyNumberTextView.setText(randomNumberGenerator.toString())
    }
}