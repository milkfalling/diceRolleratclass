package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button =//Button是封裝在一個物件裡面，原本學到的int那些是基本型別，總之冒號後面是型別沒錯，但可以指向已經封裝好的物件。
            findViewById(R.id.button)//用Button建立rollButton指向layout裡的那個button id，用的是findviewbyid方法
        rollButton.setOnClickListener { rollDice() }//在剛剛的rollButton上加入點擊監聽事件，並在事件中加入rollDice方法
        rollDice()//為了能讓使用者直覺化的知道這個APP的功用，所以一開始就顯示出骰子會比較好，於是讓程式剛執行就先roll一次吧
    }

    private fun rollDice() {//每執行一次rollDice功能就會執行以下指令
        val dice = Dice(6)//使用Dice類別建立一個六面骰，並把它叫做dice
        val diceRoll = dice.roll()//使用上一個建立的六面骰dice的roll功能，並把它叫做diceRoll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {//宣告一個drawableResource 把diceroll出來的結果數字跟每個圖片的ID綁起來
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)//然後把骰子圖片換成骰出來的id(drawableResource)
        diceImage.contentDescription = diceRoll.toString()//其實這一行不需要寫也可以執行的正確，根據教學說的這是讓AndroidStudio明白我roll出來是什麼數字，以便讓
    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
