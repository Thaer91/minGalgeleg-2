package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    Button l;
    TextView text,text2;
    private CurrentGame currentGame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        currentGame = CurrentGame.getInstance();
        text2 = findViewById(R.id.textView13);
        text = findViewById(R.id.textView12);
        text.setText(currentGame.getCurrWord());


        l = findViewById(R.id.button5);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Win.this,Main2Activity.class));
                Win.this.finish();
            }
            });
        }
}
