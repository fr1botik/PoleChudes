package com.example.polechudes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
 ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = findViewById(R.id.imageButton);





    }

    public void start(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        imageButton.startAnimation(animation);
        Thread thread = new Thread(){

            public void run(){
                try{
                    TimeUnit.SECONDS.sleep(6);
                    Intent intent = new Intent(MainActivity.this, options.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}