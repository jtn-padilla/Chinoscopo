package com.example.chinoscopo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private TextView tvFecha;
    private Button btnFecha, btnHoroscopo;
    private Calendar c;
    private DatePickerDialog dpd;
    private int YOB,MOB,DOB;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Boton de fecha de nacimiento
        btnFecha = (Button) findViewById(R.id.btnFecha);
        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int anio = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mAnio, int mMes, int mDia) {
                        //tvFecha.setText(mDia+"/"+(mMes+1)+"/"+mAnio);
                        YOB = mAnio;
                        MOB = mMes;
                        DOB = mDia;
                    }
                },dia,mes,anio);
                // Default es fecha actual
                dpd.updateDate(anio,mes,dia);
                // El maximo a escoger es hoy
                dpd.getDatePicker().setMaxDate(c.getTimeInMillis());
                // Sustraer 120 años de la fecha actual para el limite inferior
                c.add(Calendar.DATE, -365*120);
                // El minimo a escoger es hace 120 anios
                dpd.getDatePicker().setMinDate(c.getTimeInMillis());
                dpd.show();
            }
        });

        // Boton que da horoscopo, llama a validaciones
        btnHoroscopo = (Button) findViewById(R.id.btnHoroscopo);
        btnHoroscopo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Valida(v);
            }
        });
    }

    public void Valida(View view){
        // Textos de los editText
        String nombre = ((EditText)findViewById(R.id.etNombre)).getText().toString();
        String apellido = ((EditText)findViewById(R.id.etApellido)).getText().toString();
        String numcuenta = ((EditText)findViewById(R.id.etNumCuenta)).getText().toString();
        String email = ((EditText)findViewById(R.id.etEmail)).getText().toString();

        if(!nombre.isEmpty()){
            if(!apellido.isEmpty()){
                if(!numcuenta.isEmpty()){
                    if(numcuenta.length() == 10){
                        if(!email.isEmpty()){
                            if(email.trim().matches(emailPattern)){
                                if(YOB > 0){
                                    Toast.makeText(this, String.valueOf(YOB), Toast.LENGTH_SHORT).show();
                                    LlamarActivity2(view);
                                }
                                else{
                                    Toast.makeText(this, MainActivity.this.getString(R.string.FechaInv), Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(this, MainActivity.this.getString(R.string.EmailInv), Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(this, MainActivity.this.getString(R.string.EmailFalta), Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(this, MainActivity.this.getString(R.string.DigitosMal), Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(this,  MainActivity.this.getString(R.string.NumFalta), Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this,MainActivity.this.getString(R.string.ApellidoFalta) , Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(this,MainActivity.this.getString(R.string.NombreFalta) , Toast.LENGTH_SHORT).show();

        }

    }


    public void LlamarActivity2(View view) {
        // Intent a actividad 2
        Intent int2 = new Intent(getApplicationContext(), Activity2.class);
        int2.putExtra("anio",String.valueOf(YOB));
        int2.putExtra("mes",String.valueOf(MOB));
        int2.putExtra("dia",String.valueOf(DOB));

        startActivity(int2);
    }
}
