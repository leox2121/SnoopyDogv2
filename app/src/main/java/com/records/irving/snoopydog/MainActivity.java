package com.records.irving.snoopydog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.records.irving.snoopydog.BaseDatos.Perro;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button registro;

    List<Perro> perro;
    ArrayAdapter<Perro> adapter;

    ListView lvProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        perro=Perro.listAll(Perro.class);
        adapter=new ArrayAdapter<Perro>(this, android.R.layout.simple_list_item_1,perro);

        lvProducto=(ListView)findViewById(R.id.lvPerro);
        lvProducto.setAdapter(adapter);

        
    }

    public void PASO (View view){
       /* SharedPreferences datos=getSharedPreferences("Datos Perro", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=datos.edit();
        editor.putString("Datos",adapter.toString());
        editor.commit();*/
        startActivity(new Intent(MainActivity.this, Paso.class));
    }

    /*public void Guardar(){

    }*/

    public void INICIO (View view){

        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }
    public void TIPS (View view){

        startActivity(new Intent(MainActivity.this, Tips_Activity.class));
    }
    public void MAPAS (View view){

        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }



}
