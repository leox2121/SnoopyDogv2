package com.records.irving.snoopydog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.records.irving.snoopydog.BaseDatos.Usuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registroasuario extends AppCompatActivity {

    EditText uusuario;
    EditText correo;
    EditText password;
    EditText edad;
    EditText cedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registroasuario);

        uusuario=(EditText)findViewById(R.id.ednombre);
        correo=(EditText)findViewById(R.id.edcorreo);
        password=(EditText)findViewById(R.id.edpassword);
        edad=(EditText)findViewById(R.id.ededad);
        cedula=(EditText)findViewById(R.id.edcedula);
    }

    public void registrausu(View view){

        String nombre1 = uusuario.getText().toString();
        String correo1 = correo.getText().toString();
        String contra1 = password.getText().toString();
        String edad1 = edad.getText().toString();
        String cedula1 = cedula.getText().toString();

        if (!soloTexto(nombre1)) {
            uusuario.setError("Solo Texto");
        }
        if (!escorreovalido(correo1)) {
            correo.setError("Correo Invalido");
            correo.setError("El correo debe tener el siguiente formato: ejemplo@hotmail.com");
        }
        if (!escontracenavalida(contra1)) {
            password.setError("Contrasena Invalida");
            password.setError("La contrasena debe contener al menos una letra mayuscula, un numero, un simbolo y como minimo 6 caracteres");
        }
        if (!soloTexto(edad1)) {
            edad.setError("Solo Texto");
        }
        if (!soloTexto(cedula1)) {
            cedula.setError("Solo Texto");
        }else {

            Usuario usuario=new Usuario(Integer.parseInt(cedula.getText().toString()),Integer.parseInt(edad.getText().toString())
                    ,password.getText().toString(),correo.getText().toString(),uusuario.getText().toString());
            usuario.save();
            Toast.makeText(registroasuario.this, "Datos Guardados OK", Toast.LENGTH_SHORT).show();
            //Limpia los elementos
            uusuario.getText().clear();
            correo.getText().clear();
            edad.getText().clear();
            password.getText().clear();
            cedula.getText().clear();
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
}
