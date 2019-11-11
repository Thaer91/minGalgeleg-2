package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info extends AppCompatActivity implements View.OnClickListener {

    Button r,t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        r = findViewById(R.id.button3);
        r.setOnClickListener(this);

        t = findViewById(R.id.button4);
        t.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == r) {
            String URL = "https://github.com/Thaer91/minGalgeleg-2";
            Uri uri = Uri.parse(URL);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);


        }
        if (v == t){
            String URL1 = "https://en.wikipedia.org/wiki/Hangman";
            Uri uri = Uri.parse(URL1);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }

    }
}
