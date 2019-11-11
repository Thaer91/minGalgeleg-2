package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button a,b;
    CurrentGame currGame;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currGame = CurrentGame.getInstance();
        text = findViewById(R.id.textView4);



        a = findViewById(R.id.button); b = findViewById(R.id.button2);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        b = findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Info.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        text = findViewById(R.id.textView4);
        text.setText(Integer.toString(currGame.getWinCounter()));

        text = findViewById(R.id.textView5);
        text.setText(Integer.toString(currGame.getLoseCounter()));

        text = findViewById(R.id.textView9);
        text.setText(Integer.toString(currGame.getTotalGames()));


    }
}
