package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ResultsActivity extends AppCompatActivity {

    CurrentGame currGame;
    TextView text;
    SharedPreferences sP;
    SharedPreferences.Editor sPE;
    String currentGKey,sPKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        currGame = CurrentGame.getInstance();
        text = findViewById(R.id.textView16);

        sPKey = "Data";
        currentGKey = "currentGame";
        sP = getSharedPreferences(sPKey,MODE_PRIVATE);
        sPE = sP.edit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        hentData();
        text = findViewById(R.id.textView16);
        text.setText(Integer.toString(currGame.getWinCounter()));

        text = findViewById(R.id.textView17);
        text.setText(Integer.toString(currGame.getLoseCounter()));

        text = findViewById(R.id.textView18);
        text.setText(Integer.toString(currGame.getTotalGames()));


    }

    private void hentData() {
        Gson gson = new Gson();
        String json = sP.getString(currentGKey,null);
        Type type = new TypeToken<CurrentGame>(){}.getType();
        currGame = gson.fromJson(json,type);

    }
}
