package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN    // for full screen capture by app

        button.setOnClickListener{
            if(input.text.toString().isEmpty())            // if user has not entered his name
            {
                Toast.makeText(this,"Enter your name", Toast.LENGTH_SHORT).show()
            }
            else                   // if user has entered his name
            {
                var intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(SetData.name, input.text.toString())        // mapping of type vs value of data passed
                startActivity(intent)   // start next activity
                finish()                // this page work is finished
            }

        }
    }
}