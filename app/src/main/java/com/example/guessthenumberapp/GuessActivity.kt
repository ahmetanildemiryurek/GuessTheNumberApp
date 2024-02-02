package com.example.guessthenumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.guessthenumberapp.databinding.ActivityGuessBinding
import kotlin.random.*

class GuessActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGuessBinding
    private lateinit var guessBtn : Button
    private var randomNumber : Int = 0
    private var meter = 5
    private lateinit var inputEditText : EditText
    private lateinit var event : TextView
    private lateinit var trialCount : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //logcate random sayıyı loglamış oldum
        randomNumber = Random.nextInt(101)
        Log.e("Random Number" , randomNumber.toString())

        guessBtn = findViewById(R.id.guessBtn)
        event = findViewById(R.id.event)
        trialCount = findViewById(R.id.trialCount)
        inputEditText = findViewById(R.id.inputEditText)




        guessBtn.setOnClickListener {
            meter -=1

            val guess = inputEditText.text.toString().toInt()

            if (guess==randomNumber){
                val intent = Intent(this@GuessActivity , ResultActivity::class.java)

                //geçişler arası doğruluk durumunu kontrol ederek buradan imageView control yapılacak
                intent.putExtra("result",true)

                //backstackten silmek istediğim için bu fonk. ekledim
                finish()
                startActivity(intent)

                //mevcut blok çalıştıktan sonra aşağıdaki kodlar çalışmadan çıkıyor bloktan
                return@setOnClickListener
            }

            if (guess>randomNumber){
                event.text="AZALT"
                trialCount.text = "Kalan Deneme : $meter"

            }

            if (guess<randomNumber){
                event.text="ARTTIR"
                trialCount.text = "Kalan Deneme : $meter"

            }
            if (meter==0){

                val intent = Intent(this@GuessActivity , ResultActivity::class.java)

                intent.putExtra("Result",false)

                finish()

                startActivity(intent)

            }

            //her girilen veriden sonra edittext sıfırlansın istedim
            inputEditText.setText("")

        }

    }
}