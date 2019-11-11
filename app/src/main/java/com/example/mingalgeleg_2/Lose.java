package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lose extends AppCompatActivity {

    Button k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
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
