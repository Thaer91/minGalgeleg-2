package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private GalgeLogik Galge = new GalgeLogik();
    ImageView imageView;
    TextView text1, text2;
    ArrayList <Button> knapper = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        for (int i = 1; i < 27 ; i++) {
            String knapNavn = "knap" + i;
            int knapId = getResources().getIdentifier(knapNavn,"id",getPackageName());
            Button Knap = findViewById(knapId);
            knapper.add(Knap);
            Knap.setOnClickListener(this);
        }


        text1 = findViewById(R.id.text);
        text1.setText(Galge.getSynligtOrd());

        text2 = findViewById(R.id.text2);
        text2.setVisibility(View.INVISIBLE);

        imageView = findViewById(R.id.imageView);
        imageView.setBackground(getDrawable(R.drawable.forkert0));

    }

    @Override
    public void onClick(View v) {
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
                text2.setText("Du har vundet" );
                text2.setVisibility(View.VISIBLE);
            } if (Galge.erSpilletTabt()) {
                //text2.setText("نحروك يا عكروت  جرب مره تانيه");
                text2.setText("Du er død :( Prøv igen :)");
                text2.setVisibility(View.VISIBLE);
            }
        }


    }
}
