package com.records.irving.snoopydog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Paso extends AppCompatActivity {


    Button adopta;
    String dato;
    ListView lvProduct1;
    //ArrayAdapter<Perro> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso);

        //CargarDatos();
        lvProduct1=(ListView)findViewById(R.id.lvPerro1);
        //adopta.setText(adapter.toString());
    }


   /* public void CargarDatos(){
        SharedPreferences datos=getSharedPreferences("Datos Perro", Context.MODE_PRIVATE);
        dato=datos.getString("Datos",adapter.toString());
    }*/

    public void ADOPTA (View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea continuar con la Adopcion ?")
                .setTitle("Advertencia")
                .setCancelable(false)
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Continuar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Aceptar();// metodo que se debe implementar
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void Aceptar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Adopcion realizada con exito")
                .setTitle("MUCHAS GRACIAS")
                .setCancelable(false)
                .setNeutralButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                startActivity(new Intent(Paso.this, MainActivity.class));
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }



}
