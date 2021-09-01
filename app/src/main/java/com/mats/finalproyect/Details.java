package com.mats.finalproyect;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity  {

    TextView gameStory;
    Button gameLinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        gameStory = findViewById(R.id.contenidoJuego);
        Intent i = getIntent();
        String title = i.getStringExtra("titulo_del_juego");
        String description = i.getStringExtra("descripcion_delJuego");
        //comento esta linea para detectar el problema
         String enlace = i.getStringExtra("video_analisis");

        // setea el valor para el titulo del juego
        //getSupportActionBar().setTitle(title);
        getSupportActionBar().setTitle(title);

        // setea el contenido o parrafo que describe el juego en el textview. Investigar como usar Reciclerview
        gameStory.setText(description);
        gameStory.setMovementMethod(new ScrollingMovementMethod());
        //gameLinks = findViewById(R.id.btnJuego);


        //Espacio de pruebas

        //String Send_text = "https://youtu.be/gVIAAD5yUqM";

        final Button Start_search = findViewById(R.id.btnJuego);
        //Start_search.setOnClickListener(new View.OnClickListener());
        Start_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //searchWeb(Send_text.getText().toString());
                String searchCriteria = enlace;
                searchWeb(searchCriteria);
            }
        });

    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
