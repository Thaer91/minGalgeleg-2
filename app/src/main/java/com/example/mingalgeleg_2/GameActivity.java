package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private static GalgeLogik Galge = new GalgeLogik();
    ImageView imageView;
    static TextView text1;
    ArrayList <Button> knapper = new ArrayList<>();
    int winCounter, loseCounter = 0;
    CurrentGame currGame;
    SharedPreferences sP;
    SharedPreferences.Editor sPE;
    String currentGKey, sPKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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

        new Hentord().execute();

        sPKey = "Data";
        currentGKey = "currentGame";
        sP = getSharedPreferences(sPKey,MODE_PRIVATE);
        sPE = sP.edit();

        hentData();

    }
        // AsyncTask: Jeg har prøvet selv at lave det men det kunne jeg til sidst ikke, derfor fik jeg hæjlp af Nicolai
    public static class Hentord extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Galge.hentOrdFraRegneark("2");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            System.out.println(Galge.getMuligeOrd());
            text1.setText(Galge.getSynligtOrd());
        }
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
            }if (Galge.erSpilletVundet()){

                Intent intent = new Intent(this, WinActivity.class);
                intent.putExtra("word", currGame.getCurrWord());
                startActivity(intent);
                winCounter++;
                int totalWinCounter = winCounter + currGame.getWinCounter();
                int totalGames =winCounter+currGame.getTotalGames();
                currGame.setTotalGames(totalGames);
                currGame.setWinCounter(totalWinCounter);
                GameActivity.this.finish();
                Galge.nulstil();


            } if (Galge.erSpilletTabt()) {
                Intent intent = new Intent(this, LoseActivity.class);
                intent.putExtra("word", currGame.getCurrWord());
                startActivity(intent);
                loseCounter++;
                int totalLoseCounter = loseCounter + currGame.getLoseCounter();
                int totalGames =loseCounter+currGame.getTotalGames();
                currGame.setTotalGames(totalGames);
                currGame.setLoseCounter(totalLoseCounter);

                GameActivity.this.finish();
                Galge.nulstil();
            }

            sPGemData(currentGKey,currGame);
        }
    }

    private void sPGemData(String currentGKey, CurrentGame currGame) {
        Gson gson = new Gson();
        String json = gson.toJson(currGame);
        sPE.putString(currentGKey,json);
        sPE.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void hentData() {
        Gson gson = new Gson();
        String json = sP.getString(currentGKey,null);
        Type type = new TypeToken<CurrentGame>(){}.getType();
        currGame = gson.fromJson(json,type);
        if(currGame == null){
            currGame = CurrentGame.getInstance();
        }

    }

}
