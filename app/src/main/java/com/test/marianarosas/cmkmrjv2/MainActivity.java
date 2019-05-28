package com.test.marianarosas.cmkmrjv2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    //DECLARACION DE VARIABLES
    EditText etnombre;
    EditText etapp;
    EditText etapm;

    int diaac, mesac, anioac;   //Obtener fecha actual
    String signo;
    String edadf;
    String rfc;
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ASIGANACION VARIABLES A OBJETOS
        etnombre = (EditText)findViewById(R.id.etnombre);
        etapp = (EditText)findViewById(R.id.etapp);
        etapm = (EditText)findViewById(R.id.etapm);



        Button button = (Button)findViewById(R.id.bfecha);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment datePicker =new Fecha();
                datePicker.show(getSupportFragmentManager(), "Date Picker");
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "karla.charlot19@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //ENVIO DE DATOS A LA ACTIVIDAD 2
    public void Enviar(View view){
        Intent i = new Intent(this, Activity2.class);
        String nom=etnombre.getText().toString().toUpperCase();
        String ap=etapp.getText().toString().toUpperCase();
        String am=etapm.getText().toString().toUpperCase();

        //VALIDACION DE ESPACIOS VACIOS
        if(nom.length()==0 || ap.length()==0 || am.length()==0){
            Toast.makeText(this,"Ingrese todos los datos",Toast.LENGTH_LONG).show();
        }
        else {

            i.putExtra("nombre", nom);
            i.putExtra("apellidop", ap);
            i.putExtra("apellidom", am);
            i.putExtra("edadf", edadf);
            i.putExtra("signo", signo.toUpperCase());
            i.putExtra("rfc", rfc.toUpperCase());
            startActivity(i);
        }

    }


    //CALCULO DEL SOGNI DEL ZODIACO
    public String signozod(int d, int mn){
        int m =mn+1;
        String sig=" ";
        String acu="Acuario", cap="Caricornio", pis="Piscis", ar="Aries", tau="Tauro",es="Escorpio";
        String gem="Geminis", can="Cáncer", sa="Sagitario", l="Leo",vi="Virgo",li="Libra";



        //MES DE ENERO
        if(m==1){
            if(d>=20){
                sig=acu;
            }else{
                sig=cap;
            }
        }
        //MES DE FEBRERO
        if(m==2){
            if(d>=20){
                sig=pis;
            }else{
                sig=acu;
            }
        }
        //MES DE MARZO
        if(m==3){
            if(d>=21){
                sig=ar;
            }else{
                sig=pis;
            }
        }
        //MES DE ABRIL
        if(m==4){
            if(d>=21){
                sig=tau;
            }else{
                sig=ar;
            }
        }
        //MES DE MAYO
        if(m==5){
            if(d>=21){
                sig=gem;
            }else{
                sig=tau;
            }
        }
        //MES DE JUNIO
        if(m==6){
            if(d>=22){
                sig=can;
            }else{
                sig=gem;
            }
        }
        //MES DE JULIO
        if(m==7){
            if(d>=23){
                sig=l;
            }else{
                sig=can;
            }
        }
        //MES DE AGOSTO
        if(m==8){
            if(d>=24){
                sig=vi;
            }else{
                sig=l;
            }
        }
        //MES DE SEPTIEMBRE
        if(m==9){
            if(d>=24){
                sig=li;
            }else{
                sig=vi;
            }
        }
        //MES DE OCTUBRE
        if(m==10){
            if(d>=23){
                sig=es;
            }else{
                sig=vi;
            }
        }
        //MES DE NOVIEMBRE
        if(m==11){
            if(d>=23){
                sig=sa;
            }else{
                sig=es;
            }
        }
        //MES DE DICIEMBRE
        if(m==12){
            if(d>=22){
                sig=can;
            }else{
                sig=sa;
            }
        }

        return (sig);
    }



    //CALCULO DE EDAD
    public String calcular(int da, int ma, int aa, int dn, int mn, int an){
        int eda=0;

        if(aa>=2019){
            eda=2019;
        }

        if(ma>mn){
            eda=aa-an;
        }
        if(ma==mn && dn>=da){
            eda=aa-an;
        }
        else
        {
            eda=aa-an-1;
        }
            return String.valueOf(eda);

    }
    //CALCULO DE FRC
    public String rfc(int d, int m, int a, String nombre, String ap, String am) {
        String rfc1="";
        int mess=m;
        String dia2 = String.valueOf(d);
        String mes2 = String.valueOf(m+1);
        String anio4 = String.valueOf(a);
        String anio2 = anio4.substring(2,4);
        String nombre1 = nombre.substring(0, 1);
        String appater2 =ap.substring(0,2);
        String apmater1 =am.substring(0,1);


        if(m<=9 && d<=9){
            rfc1=appater2+apmater1+nombre1+anio2+"0"+mes2+"0"+dia2;
        }
        if(m<=9 && d>9){
            rfc1=appater2+apmater1+nombre1+anio2+"0"+mes2+dia2;
        }
        if(m>9 && d<=9 ) {
            rfc1 = appater2 + apmater1 + nombre1 + anio2 + mes2 + "0" + dia2;
        }
        if (m>9 && d>9)
        {
            rfc1=appater2+apmater1+nombre1+anio2+mes2+dia2;
        }

        return rfc1;
    }



    @Override
    public void onDateSet(DatePicker view, int anio , int mes, int dia) {

        //Para Fecha de nacimiento
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, anio);
        c.set(Calendar.MONTH,mes);
        c.set(Calendar.DAY_OF_MONTH,dia);
        
//CALCULO DE INFORMACION REQUERIDA
        Calendar ca = Calendar.getInstance();
        diaac=ca.get(Calendar.DAY_OF_MONTH);
        mesac=ca.get(Calendar.MONTH);
        anioac=ca.get(Calendar.YEAR);
        edadf=calcular(diaac,mesac,anioac,dia,mes,anio);
        signo=signozod(dia,mes);
        rfc=rfc(dia, mes, anio, etnombre.getText().toString(),etapp.getText().toString(),etapm.getText().toString());

    }


    //PRUEBA DE ENVIO A OTRA ACTIVIDAD

    public void Siguiente(View v){
        Intent siguiente = new Intent(this, Activity2.class);
        startActivity(siguiente);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
