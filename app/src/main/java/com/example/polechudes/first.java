package com.example.polechudes;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class first extends AppCompatActivity {


    TextView quest,otvet;
    ImageView baraban;
    Intent intent;
    Animation anim;
    String answer1;
    ImageView player1,player2,player3;
    int n,turn;
    String[]answr;
    String[]questions;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        intent = getIntent();

        quest = findViewById(R.id.question);
        baraban = findViewById(R.id.baraban);
        otvet = findViewById(R.id.answer);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        player3 = findViewById(R.id.player3);


        answr= getResources().getStringArray(R.array.ans_easy);
        questions= getResources().getStringArray(R.array.ease);

        otvet.setOnEditorActionListener(this::onEditorAction);

        anim = AnimationUtils.loadAnimation(this,R.anim.rotate);
        String a = intent.getStringExtra("baraban");

        if (a.equals("0")){
            baraban.setImageResource(R.drawable.baraban1);
        }
        else if (a.equals("1")) {
            baraban.setImageResource(R.drawable.baraban2);
        }
        else{
            baraban.setImageResource(R.drawable.bataban3);
        }
        QuestionEasy();
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if (actionId == EditorInfo.IME_ACTION_DONE) {
            answer1 = otvet.getText().toString();
            return true;
        }
        return false;
    }
    public void startspin(View view) {
            baraban.startAnimation(anim);

    }
    public void QuestionEasy (){

        Random random = new Random();
        n = random.nextInt(3);
        quest.setText(questions[n]);
    }
    public void answer(View view) {
        String[] answer_ease = getResources().getStringArray(R.array.ans_easy);

        if (otvet.getText().toString().equals(answer_ease[n])) {

            Toast.makeText(getApplicationContext(), "УГАДАЛ БИБА", Toast.LENGTH_SHORT).show();
            baraban.clearAnimation();
            QuestionEasy();
        }
        else {
            Toast.makeText(getApplicationContext(), "БОБА ТОБОЙ НЕ ДОВОЛЕН", Toast.LENGTH_SHORT).show();
            baraban.clearAnimation();
            turn = 0;
        }

    }

}


