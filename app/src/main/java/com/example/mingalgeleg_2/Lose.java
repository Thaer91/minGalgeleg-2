package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lose extends AppCompatActivity {

    private CurrentGame currentGame;

    Button k;
    TextView text,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        currentGame = CurrentGame.getInstance();
        text2 = findViewById(R.id.textView11);
        text = findViewById(R.id.textView10);
        text.setText(currentGame.getCurrWord());

        k = findViewById(R.id.button6);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lose.this,Main2Activity.class));
                Lose.this.finish();

            }
        });


    }
}
