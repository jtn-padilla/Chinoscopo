package com.example.chinoscopo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Calendar;

public class Activity2 extends AppCompatActivity {

    private TextView tvEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        String a = getIntent().getStringExtra("anio");
        String b = getIntent().getStringExtra("mes");
        String c = getIntent().getStringExtra("dia");


        tvEdad = (TextView)findViewById(R.id.tvEdad);
        int anio = Integer.parseInt(a);
        int mes = Integer.parseInt(b);
        int dia = Integer.parseInt(c);
        String texto = Activity2.this.getString(R.string.TuEdad) + calculaEdad(anio,mes,dia);
        tvEdad.setText(texto);
        dameHoroscopo(anio);

    }

    private String calculaEdad(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar hoy = Calendar.getInstance();

        dob.set(year, month, day);

        int edad = hoy.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (hoy.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
            edad--;

        Integer edadInt = new Integer(edad);
        return edadInt.toString();
    }


    private void dameHoroscopo(int YOB){

        ArrayList<Integer> aniosRata = new ArrayList<Integer>();
        ArrayList<Integer> aniosBuey = new ArrayList<Integer>();
        ArrayList<Integer> aniosTigre = new ArrayList<Integer>();
        ArrayList<Integer> aniosConejo = new ArrayList<Integer>();
        ArrayList<Integer> aniosDragon = new ArrayList<Integer>();
        ArrayList<Integer> aniosSerpiente = new ArrayList<Integer>();
        ArrayList<Integer> aniosCaballo = new ArrayList<Integer>();
        ArrayList<Integer> aniosCabra = new ArrayList<Integer>();
        ArrayList<Integer> aniosMono = new ArrayList<Integer>();
        ArrayList<Integer> aniosGallo = new ArrayList<Integer>();
        ArrayList<Integer> aniosPerro = new ArrayList<Integer>();
        ArrayList<Integer> aniosJabali = new ArrayList<Integer>();

        Calendar hoy = Calendar.getInstance();
        int anioActual = hoy.get(Calendar.YEAR);

        for(int i=1900; i<=anioActual; i+=12)
        {
            aniosRata.add(i);
            aniosBuey.add(i+1);
            aniosTigre.add(i+2);
            aniosConejo.add(i+3);
            aniosDragon.add(i+4);
            aniosSerpiente.add(i+5);
            aniosCaballo.add(i+6);
            aniosCabra.add(i+7);
            aniosMono.add(i+8);
            aniosGallo.add(i+9);
            aniosPerro.add(i+10);
            aniosJabali.add(i+11);
        }

        String horos;
        ImageView ivHoros = (ImageView)findViewById(R.id.ivHoros);
        TextView tvHoros = (TextView)findViewById(R.id.tvHoros);

        if(aniosRata.contains(YOB)){
            horos = Activity2.this.getString(R.string.Rata);
            ivHoros.setImageResource(R.drawable.rata);
        }
        else if(aniosBuey.contains(YOB)){
            horos = Activity2.this.getString(R.string.Buey);
            ivHoros.setImageResource(R.drawable.buey);
        }
        else if(aniosTigre.contains(YOB)){
            horos = Activity2.this.getString(R.string.Tigre);
            ivHoros.setImageResource(R.drawable.tigre);
        }
        else if(aniosConejo.contains(YOB)){
            horos = Activity2.this.getString(R.string.Conejo);
            ivHoros.setImageResource(R.drawable.conejo);
        }
        else if(aniosDragon.contains(YOB)){
            horos = Activity2.this.getString(R.string.Dragon);
            ivHoros.setImageResource(R.drawable.dragon);
        }
        else if(aniosSerpiente.contains(YOB)){
            horos = Activity2.this.getString(R.string.Serpiente);
            ivHoros.setImageResource(R.drawable.serpiente);
        }
        else if(aniosCaballo.contains(YOB)){
            horos = Activity2.this.getString(R.string.Caballo);
            ivHoros.setImageResource(R.drawable.caballo);
        }
        else if(aniosCabra.contains(YOB)){
            horos = Activity2.this.getString(R.string.Cabra);
            ivHoros.setImageResource(R.drawable.cabra);
        }
        else if(aniosMono.contains(YOB)){
            horos = Activity2.this.getString(R.string.Mono);
            ivHoros.setImageResource(R.drawable.mono);
        }
        else if(aniosGallo.contains(YOB)){
            horos = Activity2.this.getString(R.string.Gallo);
            ivHoros.setImageResource(R.drawable.gallo);
        }
        else if(aniosPerro.contains(YOB)){
            horos = Activity2.this.getString(R.string.Perro);
            ivHoros.setImageResource(R.drawable.perro);
        }
        else {
            horos = Activity2.this.getString(R.string.Jabali);
            ivHoros.setImageResource(R.drawable.jabali);
        }

        tvHoros.setText(horos);



    }
}
