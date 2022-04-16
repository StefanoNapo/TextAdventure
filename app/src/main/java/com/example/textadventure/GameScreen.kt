package com.example.textadventure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_screen.*
import kotlinx.android.synthetic.main.activity_title_screen.*

class  GameScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        val story = Story(this)

        choiseButton1.setOnClickListener(){
            story.selectPosition(story.nextPosition1)
        }
        choiseButton2.setOnClickListener(){
            story.selectPosition(story.nextPosition2)
        }
        choiseButton3.setOnClickListener(){
            story.selectPosition(story.nextPosition3)
        }
        choiseButton4.setOnClickListener(){
            story.selectPosition(story.nextPosition4)
        }

        story.startingPoint()
    }

}