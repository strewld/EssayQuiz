package com.example.strewldengland.essayquiz;

import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Strewld England on 2/14/2017.
 */

public class Question {
    private String mCorrectAnswer;
    private int mQuestions;

    public Question(int question, String correctAnswer){
        mQuestions = question;
        mCorrectAnswer = correctAnswer;
    }

    public int getQuestion(){
        return mQuestions;
    }

    public void setQuestion(int question){
        mQuestions = question;
    }

    public String isCorrectAnswer(){
        return mCorrectAnswer;
    }

    public void setCorrectAnswer (String correctAnswer) {
        mCorrectAnswer = correctAnswer;
    }
}
