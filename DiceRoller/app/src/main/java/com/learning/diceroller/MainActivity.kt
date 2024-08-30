package com.learning.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var result:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val click:Button = findViewById(R.id.clickme)
        click.text="Roll"
        result = findViewById(R.id.dice)
        click.setOnClickListener {
            Toast.makeText(this,"Button Click" , Toast.LENGTH_SHORT).show()
            onclick()
        }

    }
    private fun onclick(){
        val result:ImageView = findViewById(R.id.dice)
        val num = Random().nextInt(6) +1
        val dice = when (num){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        result.setImageResource(dice)
    }



}