package com.mats.finalproyect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    //Declaracion de variables de clase
    RecyclerView mRecyclerView;
    Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Obtenemos la lista de titulo del videojuego y descripcion del mismo
        String[] titles = getResources().getStringArray(R.array.videogames_title);
        String[] contents = getResources().getStringArray(R.array.game_description);

        mRecyclerView = findViewById(R.id.Game_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new Adapter(this,titles,contents);
        mRecyclerView.setAdapter(mAdapter);
    }


}