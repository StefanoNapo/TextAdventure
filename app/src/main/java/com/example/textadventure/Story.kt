package com.example.textadventure
import android.view.View
import androidx.core.app.ActivityCompat.finishAffinity
import kotlinx.android.synthetic.main.activity_game_screen.*
import kotlinx.android.synthetic.main.activity_title_screen.*


class Story (val gs:GameScreen){

    var nextPosition1 = ""
    var nextPosition2 = ""
    var nextPosition3 = ""
    var nextPosition4 = ""

    var hasSword = false
    var hasAxe = false
    var hasGold = false
    var isEnchanted = false

    fun selectPosition(position: String) {
        when (position) {
            "startingPoint" -> startingPoint()
            "sign" -> sign()
            "crossroad" -> crossroad()
            "cave" -> cave()
            "ogre" -> ogre()
            "ogreKilled" -> ogreKiller()
            "dead" -> dead()
            "dragon" -> dragon()
            "woundedDragon" -> woundedDragon()
            "dragonKilled" -> dragonKilled()
            "crossroad" -> crossroad()
            "fairy" -> fairy()
            "enchantedSword" -> enchantedSword()
            "merchant" -> merchant()
            "sword" -> sword()
            "tower" -> tower()
            "undeads" -> undeads()
            "gold" -> gold()

        }
    }

    fun showAllButtons(){

        gs.choiseButton1.setVisibility(View.VISIBLE)
        gs.choiseButton2.setVisibility(View.VISIBLE)
        gs.choiseButton3.setVisibility(View.VISIBLE)
        gs.choiseButton4.setVisibility(View.VISIBLE)
    }

    fun startingPoint(){

        gs.gameImageView.setImageResource(R.drawable.sign)
        gs.gameTextView.setText("You are walking down a road. And you see a wooden sign nearby.\n\n What will you do now?")

        gs.choiseButton1.setText("Go North")
        gs.choiseButton2.setText("Go West")
        gs.choiseButton3.setText("Go East")
        gs.choiseButton4.setText("Read the sign")

        showAllButtons()

        nextPosition1 = "dragon"
        nextPosition2 = "crossroad"
        nextPosition3 = "cave"
        nextPosition4 = "sign"

    }

    fun dead(){

        hasGold = false
        hasSword = false
        hasAxe = false
        isEnchanted = false

        gs.gameImageView.setImageResource(R.drawable.grave)
        gs.gameTextView.setText("You have met your demise\n\n But maybe you have better luck in your next life...\nWhat will you do now?")

        gs.choiseButton1.setText("Restart")
        gs.choiseButton2.setText("")
        gs.choiseButton3.setText("")
        gs.choiseButton4.setText("")

        gs.choiseButton2.setVisibility(View.INVISIBLE)
        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "startingPoint"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun sign(){

        gs.gameImageView.setImageResource(R.drawable.signcloseup)
        gs.gameTextView.setText("The sign reads: \n\n \"DRAGON AHEAD!!!\"")

        gs.choiseButton1.setText("Go Back")
        gs.choiseButton2.setText("")
        gs.choiseButton3.setText("")
        gs.choiseButton4.setText("")

        gs.choiseButton2.setVisibility(View.INVISIBLE)
        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "startingPoint"
        nextPosition2 = ""
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun crossroad(){
        gs.gameImageView.setImageResource(R.drawable.crossroadtwo)
        gs.gameTextView.setText("You walk to the West and you find an other crossroad\n What will you do now?")

        gs.choiseButton1.setText("Go North")
        gs.choiseButton2.setText("Go West")
        gs.choiseButton3.setText("Go East")
        gs.choiseButton4.setText("Go Back")

        showAllButtons()

        nextPosition1 = "fairy"
        nextPosition2 = "merchant"
        nextPosition3 = "tower"
        nextPosition4 = "startingPoint"
    }

    fun fairy(){
        gs.gameImageView.setImageResource(R.drawable.fairy)
        if(isEnchanted) {
            gs.gameTextView.setText("I gave my best into that sword \n Hope it can serve you well.")
        }
        else{
            gs.gameTextView.setText("You find a fairy and she says to you: \n\"Hello adventurer, if you are in need of my magic just tell me\"")
        }


        gs.choiseButton1.setText("Go Back to the SECOND crossroad")

        gs.choiseButton2.setText("Go Back to the FIRST crossroad")

        if(hasSword && !isEnchanted)
        {
            gs.choiseButton3.setText("Give her your sword")
            gs.choiseButton3.setVisibility(View.VISIBLE)
        }
        else
            gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setText("")


        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "crossroad"
        nextPosition2 = "startingPoint"
        if(hasSword) {
            nextPosition3 = "enchantedSword"
            isEnchanted = true
        }
        nextPosition4 = ""
    }

    fun enchantedSword(){
        gs.gameImageView.setImageResource(R.drawable.enchantedsword)
        gs.gameTextView.setText("The fairy looks at your sword and chant a spell while she covers the blade with magic dusts. \nAnd then says: \"I hope this helps you in your most important fight.\"")

        gs.choiseButton1.setText("Go Back to the SECOND crossroad")
        gs.choiseButton2.setText("Go Back to the FIRST crossroad")

        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "crossroad"
        nextPosition2 = "startingPoint"

    }

    fun merchant(){
        gs.gameImageView.setImageResource(R.drawable.merchant)
        if(hasSword) {
            gs.gameTextView.setText("I sold you my last sword. \n Greatest steel of this lands...if you ask me of course!")
        }
        else{
            gs.gameTextView.setText("You cross path with the merchant and he tells you: \n\"I can tell that your are looking for glory but...\nWithout a weapon that is not going to be an easy task.\n I can sell you one if you find some gold for me.\"")
        }


        gs.choiseButton1.setText("Go Back to the SECOND crossroad")

        gs.choiseButton2.setText("Go Back to the FIRST crossroad")

        if(hasGold && !hasSword)
        {
            gs.choiseButton3.setText("Give him the gold sack")
            gs.choiseButton3.setVisibility(View.VISIBLE)
        }
        else
            gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setText("")


        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "crossroad"
        nextPosition2 = "startingPoint"
        if(hasGold) {
            nextPosition3 = "sword"
            hasSword = true
        }
        nextPosition4 = ""
    }

    fun sword(){
        gs.gameImageView.setImageResource(R.drawable.sword)
        gs.gameTextView.setText("The merchant takes the sack and inspect the coins. \nThen says: \"Well this should be enough for this Sword. Wish you the best at your journey.\" \n And he brings you his sword.")

        gs.choiseButton1.setText("Go Back to the SECOND crossroad")
        gs.choiseButton2.setText("Go Back to the FIRST crossroad")

        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "crossroad"
        nextPosition2 = "startingPoint"
    }

    fun tower(){
        gs.gameImageView.setImageResource(R.drawable.tower)

        if(hasGold || hasSword) {
            gs.gameTextView.setText("There is nothing else that you can make use of here")
        }
        else{
            gs.gameTextView.setText("You got in front of you an abandon tower...it may have something that could help you...")
        }


        gs.choiseButton1.setText("Go Inside")
        gs.choiseButton2.setText("Go Back")
        gs.choiseButton3.setText("")
        gs.choiseButton4.setText("")

        if (hasGold) {
            gs.choiseButton1.setVisibility(View.INVISIBLE)
        }
        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)


        nextPosition1 = "undeads"
        nextPosition2 = "crossroad"
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun undeads(){
        gs.gameImageView.setImageResource(R.drawable.undeads)
        gs.gameTextView.setText("You go inside the tower and manage to see not too far from you a sack with some coins in the floor\nBut at the same time something starts moving towards you...\nRotten undead bodies that wants your flesh!\nWhat will you do?")

        gs.choiseButton1.setText("Run from the tower!")
        gs.choiseButton2.setText("Run for the sack!")
        gs.choiseButton3.setText("")
        gs.choiseButton4.setText("")

        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "crossroad"
        nextPosition2 = "gold"
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun gold(){
        hasGold = true
        gs.gameImageView.setImageResource(R.drawable.goldsack)
        gs.gameTextView.setText("You run for the sack, you manage to grave it and run as fast as you can to the exit.\nThe undeads almost catches you, but in the last moment you jump throw the door and one of the arms that follows you falls and burns for the sun.")

        gs.choiseButton1.setText("Go Back to the SECOND crossroad")
        gs.choiseButton2.setText("Go Back to the FIRST crossroad")

        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "crossroad"
        nextPosition2 = "startingPoint"
    }

    fun cave(){

        gs.gameImageView.setImageResource(R.drawable.cave)
        if(hasAxe) {
            gs.gameTextView.setText("There is nothing else that you can make use of here")
        }
        else{
            gs.gameTextView.setText("You find a cave...\nand it looks that something could be inside")
        }


        gs.choiseButton1.setText("Look inside")
        gs.choiseButton2.setText("Go Back")
        gs.choiseButton3.setText("")
        gs.choiseButton4.setText("")

        if (hasAxe) {
            gs.choiseButton1.setVisibility(View.INVISIBLE)
        }
        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "ogre"
        nextPosition2 = "startingPoint"
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun ogre() {
        gs.gameImageView.setImageResource(R.drawable.ogrecave)
        gs.gameTextView.setText("You enter the ogre house and he does not like visitors")

        gs.choiseButton1.setText("Fight!")
        gs.choiseButton2.setText("Run!")
        gs.choiseButton3.setText("Try some chatting")
        gs.choiseButton4.setText("")

        gs.choiseButton3.setVisibility(View.VISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        if (hasSword) {
            nextPosition1 = "ogreKilled"
            hasAxe = true
        } else {
            nextPosition1 = "dead"
        }
        nextPosition2 = "startingPoint"
        nextPosition3 = "dead"
        nextPosition4 = ""
    }

    fun ogreKiller(){
        gs.gameImageView.setImageResource(R.drawable.axe)
        gs.gameTextView.setText("You killed the orc and found and Axe that could help you later, so you pick it up")

        gs.choiseButton1.setText("Go Back")

        gs.choiseButton2.setVisibility(View.INVISIBLE)
        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        nextPosition1 = "startingPoint"


    }

    fun dragon(){
        gs.gameImageView.setImageResource(R.drawable.dragon)
        gs.gameTextView.setText("You are facing the mighty dragon!")

        gs.choiseButton1.setText("Fight!")
        gs.choiseButton2.setText("Run!")
        gs.choiseButton3.setText("Throw an axe!")
        gs.choiseButton4.setText("")

        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        if (hasAxe){
            gs.choiseButton3.setVisibility(View.VISIBLE)
        }

        nextPosition1 = "dead"
        nextPosition2 = "dead"
        nextPosition3 = "woundedDragon"
        nextPosition4 = ""
    }

    fun woundedDragon(){
        gs.gameImageView.setImageResource(R.drawable.dragon)
        gs.gameTextView.setText("The dragon is now wounded and falls into the ground")

        gs.choiseButton1.setText("Fight!")
        gs.choiseButton2.setText("Run!")
        gs.choiseButton3.setText("")
        gs.choiseButton4.setText("")

        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

        if (hasSword && isEnchanted){
            nextPosition1 = "dragonKilled"
        }
        else{
            nextPosition1 = "dead"
        }

        nextPosition2 = "dead"
        nextPosition3 = ""
        nextPosition4 = ""
    }

    fun dragonKilled(){
        gs.gameImageView.setImageResource(R.drawable.knightwin)
        gs.gameTextView.setText("You killed the mighty dragon and save the village!!! \nThe King gives you the title of Knight and a great reward for your heroic deeds.\n\nThe End...for now")

        gs.choiseButton1.setVisibility(View.INVISIBLE)
        gs.choiseButton2.setVisibility(View.INVISIBLE)
        gs.choiseButton3.setVisibility(View.INVISIBLE)
        gs.choiseButton4.setVisibility(View.INVISIBLE)

    }


}