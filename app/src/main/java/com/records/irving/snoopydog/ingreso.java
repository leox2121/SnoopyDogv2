package com.records.irving.snoopydog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.records.irving.snoopydog.BaseDatos.Perro;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ingreso extends AppCompatActivity {

    EditText raza;
    EditText nombre;
    EditText edad;
    EditText numero;
    private Button bt_hacerfoto;
    private ImageView img;
    int secuencia = 0;

    String imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Relacionamos con el XML
        img = (ImageView)findViewById(R.id.imageView);
        bt_hacerfoto = (Button)findViewById(R.id.capturar);
        //galeria = (Button)findViewById(R.id.consulta);

        final SharedPreferences sharedPreferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        nombre=(EditText)findViewById(R.id.ingresenobre);
        raza=(EditText)findViewById(R.id.ingreseraza);
        edad=(EditText)findViewById(R.id.ingreseedad);
        numero=(EditText)findViewById(R.id.ingresenumero);

        bt_hacerfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent para llamar a la Camara
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //Creamos una carpeta en la memeria del terminal
                File imagesFolder = new File(
                        Environment.getExternalStorageDirectory(),"SnoopyDog");
                imagesFolder.mkdirs();
                //añadimos el nombre de la imagen
                secuencia = sharedPreferences.getInt("Valor",0);
                secuencia = (secuencia+1);
                editor.putInt("Valor",secuencia);
                editor.commit();
                String nombre = ("Foto"+ secuencia);
                File image = new File(imagesFolder, nombre +".jpg");
                Uri uriSavedImage = Uri.fromFile(image);
                //Le decimos al Intent que queremos grabar la imagen
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                //Lanzamos la aplicacion de la camara con retorno (forResult)
                startActivityForResult(cameraIntent, 1);
                imagen="/SnoopyDog/"+nombre+".jpg";
            }});


    }


    public void Registrar(View view){

        String nombre1 = nombre.getText().toString();
        String raza1 = raza.getText().toString();
        String edad1 = edad.getText().toString();
        String numero1 = numero.getText().toString();

        if (!soloTexto(nombre1)) {
            nombre.setError("Solo Texto");
        }
        if (!soloTexto(raza1)) {
            raza.setError("Solo Texto");
        }
        if (!soloTexto(edad1)) {
            edad.setError("Solo Texto");
        }
        if (!soloTexto(numero1)) {
            numero.setError("Solo Texto");
        }
         else {

            Perro perro=new Perro(raza.getText().toString(),nombre.getText().toString(),edad.getText().toString(),numero.getText().toString()
                    ,imagen.toString());

            perro.save();
            Toast.makeText(ingreso.this, "Datos Guardados OK", Toast.LENGTH_SHORT).show();
            //Limpia los elementos
            nombre.getText().clear();
            raza.getText().clear();
            edad.getText().clear();
            numero.getText().clear();

        }
    }

    private boolean soloTexto(String text) {
        String texto = "^([_A-Za-z-]+)*([\\s]+)*([_A-Za-z-]+)$";
        Pattern pattern = Pattern.compile(texto);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
    private boolean escorreovalido(String email) {
        String correo = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(correo);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
    private boolean escontracenavalida(String pass) {
        String pattern1 = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Comprovamos que la foto se a realizado
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Creamos un bitmap con la imagen recientemente
            //almacenada en la memoria
            final SharedPreferences sharedPreferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
            secuencia = sharedPreferences.getInt("Valor",0);
            String nombre = ("Foto"+ secuencia);
            Bitmap bMap = BitmapFactory.decodeFile(
                    Environment.getExternalStorageDirectory() +
                            "/SnoopyDog/" + nombre + ".jpg");
            //Añadimos el bitmap al imageView para
            //mostrarlo por pantalla
            img.setImageBitmap(bMap);

        }


    }

    public void INICIO (View view){

        startActivity(new Intent(ingreso.this, MainActivity.class));
    }
    public void TIPS (View view){

        startActivity(new Intent(ingreso.this, Tips_Activity.class));
    }
    public void MAPAS (View view){

        startActivity(new Intent(ingreso.this, MapsActivity.class));
    }
}
