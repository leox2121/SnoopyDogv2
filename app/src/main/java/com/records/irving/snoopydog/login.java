package com.records.irving.snoopydog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Usuario on 17/01/2016.
 */
public class login extends MainActivity {
    Button loguear;
    EditText usu;
    EditText contra;
    String admin="root";
    String pass="root";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usu=(EditText)findViewById(R.id.usuario);
        contra=(EditText)findViewById(R.id.password);
        loguear=(Button)findViewById(R.id.login);

        loguear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre1 = usu.getText().toString();
                String contra1 = contra.getText().toString();

                if (!soloTexto(nombre1)) {
                    usu.setError("Solo Texto");
                }
                if (!escontracenavalida(contra1)) {
                    contra.setError("Contrasena Invalida");
                    contra.setError("La contrasena debe contener al menos una letra mayuscula, un numero, un simbolo y como minimo 6 caracteres");
                }else {

                    if ((usu.getText().toString() == admin) && (contra.getText().toString() == pass)) {

                        startActivity(new Intent(login.this, ingreso.class));
                    } else {
                        //Toast.makeText(login.this, "", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this, ingreso.class));
                    }

                }


            }
        });

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

    public void Registrarse (View view){

        startActivity(new Intent(login.this, registroasuario.class));
    }
}
