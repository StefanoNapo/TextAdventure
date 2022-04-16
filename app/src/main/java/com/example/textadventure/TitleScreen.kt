package com.example.textadventure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import kotlinx.android.synthetic.main.activity_title_screen.*


class TitleScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title_screen)

        startButton.setOnClickListener{

        val Intent = Intent(this, GameScreen:: class.java)
        startActivity(Intent)

        }
    }
}