package com.example.mingalgeleg_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String [] words= new String[]{"hello", "land","mus", "hejhej", "handi","hej", "jaja", "yamyam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);


        ArrayAdapter aAdapter = new ArrayAdapter(this, R.layout.activity_liste,R.id.textView6, words);

        ListView listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(aAdapter);
        setContentView(listView);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String word = parent.getItemAtPosition(position).toString();
        String meantWord = "meantWord";
        startActivity(new Intent(ListeActivity.this, GameActivityWord.class).putExtra(meantWord,word));
        System.out.println(word);
    }
}
