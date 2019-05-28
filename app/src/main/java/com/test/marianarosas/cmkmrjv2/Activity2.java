package com.test.marianarosas.cmkmrjv2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    //DECLARACION DE VARIABLES
    private TextView tvresult;
    private TextView tvnombre;
    private TextView tvapp;
    private TextView tvsignoz;
    private TextView tvrfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Nombre
        tvnombre = (TextView)findViewById(R.id.tvnombre);
        String nombre = getIntent().getStringExtra("nombre");
        tvnombre.setText(nombre);

        //Apellidos
        tvapp = (TextView)findViewById(R.id.tvappm);
        String apellidom = getIntent().getStringExtra("apellidom");
        String apellidop = getIntent().getStringExtra("apellidop");
        tvapp.setText(apellidop +" " +apellidom);

        //Edad
        tvresult = (TextView)findViewById(R.id.tvresult);
        String edadf = getIntent().getStringExtra("edadf");
        tvresult.setText(edadf);

        //Signo Zodiacal
        tvsignoz = (TextView)findViewById(R.id.tvSignoz);
        String signo = getIntent().getStringExtra("signo");
        tvsignoz.setText(signo);

        //RFC
        tvrfc = (TextView)findViewById(R.id.tvrfc);
        String rfc = getIntent().getStringExtra("rfc");
        tvrfc.setText(rfc);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //Metodo para el metodo Regresar a la actividad 1

    public void anterior(View view){
        Intent  anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);

    }

}
