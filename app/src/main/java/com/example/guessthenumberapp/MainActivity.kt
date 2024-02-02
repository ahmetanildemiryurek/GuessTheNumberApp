package com.example.guessthenumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.guessthenumberapp.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var startBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startBtn = findViewById(R.id.startBtn)

        startBtn.setOnClickListener {
            //aktivity'ler arası geçiş yapacağımız için intent nesnesini kullandık
            val intent = Intent(this@MainActivity , GuessActivity::class.java)
            startActivity(intent)

        }



    }
}