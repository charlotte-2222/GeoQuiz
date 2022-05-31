package com.example.charlotte_childers_cpt_188_lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //Vars
    private lateinit var trueBtn:Button
    private lateinit var falseBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueBtn=findViewById(R.id.true_button)
        falseBtn=findViewById(R.id.false_button)


        //methods
        trueBtn.setOnClickListener{view:View ->
         Toast.makeText(
             this,
             R.string.correct_toast,
             Toast.LENGTH_SHORT
         ).show()
        }
        falseBtn.setOnClickListener{view:View ->
        Toast.makeText(
            this,
            R.string.incorrect_toast,
            Toast.LENGTH_SHORT
        ).show()
        }



    }
}