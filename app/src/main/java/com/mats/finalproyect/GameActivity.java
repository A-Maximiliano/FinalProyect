package com.mats.finalproyect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    //Declaracion de variables de clase
    RecyclerView mRecyclerView;
    Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

      /*  String Send_text = "https://youtu.be/gVIAAD5yUqM";

        final Button Start_search = findViewById(R.id.btnJuego);
        //Start_search.setOnClickListener(new View.OnClickListener());
        Start_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //searchWeb(Send_text.getText().toString());
                String searchCriteria = Send_text;
                searchWeb(searchCriteria);
           }
        });*/

        // Obtenemos la lista de titulo del videojuego y descripcion del mismo
        String[] titles = getResources().getStringArray(R.array.videogames_title);
        String[] contents = getResources().getStringArray(R.array.game_description);
        String[] enlace = getResources().getStringArray(R.array.game_link);

        mRecyclerView = findViewById(R.id.Game_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new Adapter(this,titles,contents,enlace);
        mRecyclerView.setAdapter(mAdapter);
    }

   /* public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }*/


}