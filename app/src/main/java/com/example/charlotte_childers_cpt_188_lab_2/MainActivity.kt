/*Charlotte Childers
* CPT-188-Lab-3
* 6-11-2022
* --Updates to GeoQuiz applet
*/

package com.example.charlotte_childers_cpt_188_lab_2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    //Vars
    private lateinit var trueBtn:Button
    private lateinit var falseBtn:Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView



    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProvider(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)



        trueBtn=findViewById(R.id.true_button)
        falseBtn=findViewById(R.id.false_button)
        nextButton=findViewById(R.id.next_button)
        questionTextView=findViewById(R.id.question_text_view)




        trueBtn.setOnClickListener{
            checkAnswer(true)
        }

        falseBtn.setOnClickListener{
            checkAnswer(false)
        }

        nextButton.setOnClickListener{
            quizViewModel.moveToNext()
            updateQuestion()
        }

        updateQuestion()

    }

    private fun updateQuestion(){
        val questionTestResId=quizViewModel.currentQuestionText
        questionTextView.setText(questionTestResId)
    }

    private fun checkAnswer(userAnswer:Boolean){
        val correctAnswer=quizViewModel.currentQuestionAnswer

        val messageResId=if(userAnswer==correctAnswer){
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