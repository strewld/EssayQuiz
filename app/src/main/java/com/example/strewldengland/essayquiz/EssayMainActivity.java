package com.example.strewldengland.essayquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EssayMainActivity extends AppCompatActivity {

    private Button mSubmit, mPrev, mNext;
    private TextView mSoal;
    private EditText mJawab;

    private String mAnswer;
    private int operation = 0;
    private Question[] mQuestionLibrary = new Question[]{
            new Question(R.string.pertama, "Tidak ada"),
            new Question(R.string.kedua, "Maluku"),
            new Question(R.string.ketiga, "9"),
    };

    private int mQuestionNumber = 0;

    private void updateQuestion(){
        int question = mQuestionLibrary[mQuestionNumber].getQuestion();
        mSoal.setText(question);
    }

    private void checkAnswer(String answerTrue){
        String answerIsTrue = mQuestionLibrary[mQuestionNumber].isCorrectAnswer();
        if (answerTrue == answerIsTrue){
            Toast.makeText(EssayMainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(EssayMainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay_main);

        mSoal = (TextView)findViewById(R.id.soal);
        int question = mQuestionLibrary[mQuestionNumber].getQuestion();
        mSoal.setText(question);

        mSubmit = (Button)findViewById(R.id.result);
        mPrev = (Button)findViewById(R.id.prev);
        mNext = (Button)findViewById(R.id.next);
        mJawab = (EditText) findViewById(R.id.jawab);

        mSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mAnswer = mJawab.getText().toString();
                checkAnswer(mAnswer);
                mQuestionNumber = (mQuestionNumber + 1) % mQuestionLibrary.length;
                updateQuestion();
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestionNumber = (mQuestionNumber + 1) % mQuestionLibrary.length;
                updateQuestion();
            }
        });

        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestionNumber = (mQuestionNumber - 1) % mQuestionLibrary.length;
                if (mQuestionNumber < 0) mQuestionNumber = mQuestionLibrary.length-1;
                updateQuestion();
            }
        });
    }

    public void clear(View V){
        mJawab.setText("");
        operation = 0;
    }
}
