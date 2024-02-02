package com.example.guessthenumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.guessthenumberapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityResultBinding
    private  lateinit var guessAgainBtn : Button
    private  lateinit var resultTextView: TextView
    private  lateinit var imageViewResult: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        guessAgainBtn = findViewById(R.id.guessAgainBtn)
        resultTextView = findViewById(R.id.resultTextView)
        imageViewResult = findViewById(R.id.imageViewResult)



        val result = intent.getBooleanExtra("Result" , true)

            if (result){
                resultTextView.text = "KAZANDINIZ!!!"
                imageViewResult.setImageResource(R.drawable.success_icon)
            }
            else{
                resultTextView.text = "KAYBETTİNZ!!!"
                imageViewResult.setImageResource(R.drawable.failed_icon)
            }


        guessAgainBtn.setOnClickListener {
            val intent = Intent(this@ResultActivity,GuessActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}