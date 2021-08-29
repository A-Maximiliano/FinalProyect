package com.mats.finalproyect;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity  {

    TextView gameStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        gameStory = findViewById(R.id.contenidoJuego);
        Intent i = getIntent();
        String title = i.getStringExtra("titulo_del_juego");
        String description = i.getStringExtra("descripcion_delJuego");

        // setea el valor para el titulo del juego
        getSupportActionBar().setTitle(title);

        // setea el contenido o parrafo que describe el juego en el textview
        gameStory.setText(description);
        gameStory.setMovementMethod(new ScrollingMovementMethod());
    }

}
