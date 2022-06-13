/*Charlotte Childers
* CPT-188-Lab-3
* 6-11-2022
* --Updates to GeoQuiz applet
*/

package com.example.charlotte_childers_cpt_188_lab_2

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    //Vars
    private lateinit var trueBtn:Button
    private lateinit var falseBtn:Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank=listOf(
        Question(R.string.question_sc, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        trueBtn=findViewById(R.id.true_button)
        falseBtn=findViewById(R.id.false_button)
        nextButton=findViewById(R.id.next_button)
        questionTextView=findViewById(R.id.question_text_view)




        trueBtn.setOnClickListener{view:View ->
            checkAnswer(true)
        }

        falseBtn.setOnClickListener{view:View ->
            checkAnswer(false)
        }

        nextButton.setOnClickListener{
            currentIndex=(currentIndex+1)%questionBank.size
            updateQuestion()
        }

        updateQuestion()

    }

    private fun updateQuestion(){
        val questionTextResId=questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer:Boolean){
        val correct=questionBank[currentIndex].answer

        val messageResId=if(userAnswer==correct){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()

        //info related to Toast gravity
        //however Android 11 / Api 30
        //The effect will *not* work
        //https://developer.android.com/reference/kotlin/android/os/Build.VERSION_CODES.html#R:kotlin.Int

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

}