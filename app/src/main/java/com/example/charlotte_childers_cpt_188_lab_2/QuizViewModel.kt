package com.example.charlotte_childers_cpt_188_lab_2

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG="QuizViewModel"

class QuizViewModel: ViewModel() {
    init{
        Log.d(TAG,"ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"ViewModel instance queued for termination")
    }



}