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

public class WinActivity extends AppCompatActivity {

    Button knap;
    TextView text,text2, text3;
    private CurrentGame currentGame;
    MediaPlayer Win;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        String word = getIntent().getStringExtra("word");

        Win = MediaPlayer.create(getApplicationContext(),R.raw.win_sound);
        Win.start();
        currentGame = CurrentGame.getInstance();
        text2 = findViewById(R.id.textView13);
        text = findViewById(R.id.textView12);
        text.setText(currentGame.getCurrWord());

        text3 = findViewById(R.id.textView4);
        Animation animation =  AnimationUtils.loadAnimation(this,R.anim.hyperspace_out);
        text3.startAnimation(animation);


        knap = findViewById(R.id.button5);
        knap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WinActivity.this, MainActivity.class));
                WinActivity.this.finish();
            }
            });
        }

    @Override
    protected void onPause() {
        super.onPause();
        Win.release();
    }
}
