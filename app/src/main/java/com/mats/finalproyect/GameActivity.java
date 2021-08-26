package com.mats.finalproyect;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class GameActivity extends AppCompatActivity {

    //Declaracion de variables de clase
    RecyclerView recyclerView;
    Adapter adapter;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navi_view);
       // navigationView.setNavigationItemSelectedListener(this);

        drawer = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        // Obtenemos la lista de titulo del videojuego y descripcion del mismo
        String[] titles = getResources().getStringArray(R.array.videogames_title);
        String[] contents = getResources().getStringArray(R.array.game_description);

        recyclerView = findViewById(R.id.storiesListsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,titles,contents); // our adapter takes two string array
        recyclerView.setAdapter(adapter);
    }


}