package com.mats.finalproyect;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> {

    private LayoutInflater layoutF;
    private String[] sTitles;
    private String[] sDescription;

    Adapter(Context context, String[] titles, String[] contents){
        this.layoutF = LayoutInflater.from(context);
        this.sTitles = titles;
        this.sDescription = contents;
    }

    //Creacion de clase interna anidada
    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutF.inflate(R.layout.custom_view_game_list,viewGroup,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holderGameInfo, int i) {
        String title = sTitles[i];
        String content = sDescription[i];
        holderGameInfo.gameTitle.setText(title);
        holderGameInfo.gameDescription.setText(content);
        holderGameInfo.number.setText(String.valueOf(title.charAt(0)));

        // Propiedad para dar forma
        GradientDrawable forma = new GradientDrawable();
        forma.setShape(GradientDrawable.RECTANGLE);

        // Con Random podemos generar al azar numeros para utilizar en la seleccion de colores para el cardview. Repasar video https://youtu.be/JLTUPaWVGm4
        Random rdm = new Random();
        int colorRojo = rdm.nextInt(255 - 0 + i);
        int colorGreen = rdm.nextInt(255 - i + 1);
        int colorBlue = rdm.nextInt(255 - 0 + (i+1));
        forma.setColor(Color.rgb(colorRojo,colorGreen,colorBlue));
        holderGameInfo.circle.setBackground(forma);
    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        TextView gameTitle, gameDescription,number;
        CardView circle;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                Intent i = new Intent(v.getContext(),Details.class);
                // enviar titulo y contenido de descripcion recyclerview
                i.putExtra("titulo_del_juego",sTitles[getAdapterPosition()]);
                i.putExtra("descripcion_delJuego", sDescription[getAdapterPosition()]);
                v.getContext().startActivity(i);
            });
            gameTitle = itemView.findViewById(R.id.gameTitle);
            gameDescription = itemView.findViewById(R.id.gameDescription);
            number = itemView.findViewById(R.id.number);
            circle = itemView.findViewById(R.id.forma);


        }
    }

}
