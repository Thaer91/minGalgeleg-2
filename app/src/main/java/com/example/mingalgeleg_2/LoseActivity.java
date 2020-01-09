package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    //private CurrentGame currentGame;
    CurrentGame currentGame;

    Button k;
    TextView text,text2, text3;
    MediaPlayer Lose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);


        String word = getIntent().getStringExtra("word");

        Lose = MediaPlayer.create(getApplicationContext(),R.raw.lose_sound);
        Lose.start();

        currentGame = CurrentGame.getInstance();
        text2 = findViewById(R.id.randomText);
        text  = findViewById(R.id.theWord);
        text.setText(word);


        text3 = findViewById(R.id.youLose);
        Animation animation =  AnimationUtils.loadAnimation(this,R.anim.hyperspace_out);
        text3.startAnimation(animation);

        k = findViewById(R.id.button6);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoseActivity.this, MainActivity.class));
                LoseActivity.this.finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lose.release();

    }
}
