package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class GameActivityWord extends AppCompatActivity implements View.OnClickListener {

    private static GalgeLogik Galge = new GalgeLogik();
    ImageView imageView;
    static TextView text1;
    ArrayList <Button> knapper = new ArrayList<>();
    CurrentGame currGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String meantWord = getIntent().getStringExtra("meantWord");
        Galge.muligeOrd.add(meantWord);
        Galge.nulstilmeantword();

        currGame = CurrentGame.getInstance();

        for (int i = 1; i < 31 ; i++) {
            String knapNavn = "knap" + i;
            int knapId = getResources().getIdentifier(knapNavn,"id",getPackageName());
            Button Knap = findViewById(knapId);
            knapper.add(Knap);
            Knap.setOnClickListener(this);
        }

        text1 = findViewById(R.id.text);
        text1.setText(Galge.getSynligtOrd());
        imageView = findViewById(R.id.imageView);
        imageView.setBackground(getDrawable(R.drawable.forkert0));
    }

    @Override
    public void onClick(View v) {
        currGame.setCurrWord(Galge.getOrdet());
        if (!Galge.erSpilletSlut()) {

            for (int i = 0; i < knapper.size() ; i++) {

                if (knapper.get(i) == v) {
                    knapper.get(i).setVisibility(View.INVISIBLE);
                    String pogstav = knapper.get(i).getText().toString();
                    Galge.gætBogstav(pogstav);

                    if (Galge.erSidsteBogstavKorrekt()) {
                        text1.setText(Galge.getSynligtOrd());
                    } else {
                        int billedeNr = Galge.getAntalForkerteBogstaver();
                        String billedeNavn = "forkert" + billedeNr;
                        int billedeID = getResources().getIdentifier(billedeNavn,"drawable",getPackageName());
                        imageView.setBackground(getDrawable(billedeID));
                    }
                }
            } if (Galge.erSpilletVundet()){
                Intent intent = new Intent(this, WinActivity.class);
                intent.putExtra("word", currGame.getCurrWord());
                startActivity(intent);
                GameActivityWord.this.finish();
                Galge.nulstil();


            } if (Galge.erSpilletTabt()) {
                Intent intent = new Intent(this, LoseActivity.class);
                intent.putExtra("word", currGame.getCurrWord());
                startActivity(intent);
                GameActivityWord.this.finish();
                Galge.nulstil();
            }
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

    }
}

