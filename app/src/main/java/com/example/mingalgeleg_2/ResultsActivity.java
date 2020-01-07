package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    CurrentGame currGame;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        currGame = CurrentGame.getInstance();
        text = findViewById(R.id.textView16);

    }

    @Override
    protected void onResume() {
        super.onResume();
        text = findViewById(R.id.textView16);
        text.setText(Integer.toString(currGame.getWinCounter()));

        text = findViewById(R.id.textView17);
        text.setText(Integer.toString(currGame.getLoseCounter()));

        text = findViewById(R.id.textView18);
        text.setText(Integer.toString(currGame.getTotalGames()));


    }
}
