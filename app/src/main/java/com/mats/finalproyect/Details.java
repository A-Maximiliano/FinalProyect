package com.mats.finalproyect;

import static java.net.Proxy.Type.HTTP;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Details extends AppCompatActivity  {

    TextView gameStory;
    Button gameLinks;
    String title;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        gameStory = findViewById(R.id.contenidoJuego);
        Intent i = getIntent();
        title = i.getStringExtra("titulo_del_juego");
        description = i.getStringExtra("descripcion_delJuego");
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
                //composeMmsMessage();
            }
        });

        //Pruebas para enviar sms
        if (ActivityCompat.checkSelfPermission(Details.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){

        }

    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //Aqui inicio prueba para funcionalidad del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_send_msj) {
            sendEmail();
            return true;
        }

       /* SmsManager sms = SmsManager.getDefault();
        String subject = title;
        MenuItem idsms = findViewById(R.id.action_send_msj);
        String text = "Mira lo que aprendi en el curso de \"" + subject + "\"\n" + description;
        sms.sendTextMessage(idsms.getTitle().toString(), null, null, null, null);*/

       /* if (id == R.id.action_send_msj) {
            //String subject = title;
            //String text = "Mira lo que aprendi en el curso de \"" + subject + "\"\n" + description;
            composeMmsMessage(text);
            return true;
        }*/

        return super.onOptionsItemSelected(item);

    }

    private void sendEmail() {
       // CourseInfo course = (CourseInfo) mSpinnerCourses.getSelectedItem();
        String titleGame = title; //getText().toString();
        String text = "Personalmente recomiendo el juego \"" + titleGame + "\"\n" + description;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc2822");

        intent.putExtra(Intent.EXTRA_SUBJECT, titleGame);
        intent.putExtra(Intent.EXTRA_TEXT, text);

        startActivity(intent);

    }

   /* public void composeMmsMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("sms_body", message);
        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }*/

  /*  public void viewContact(Uri contactUri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }*/

}
