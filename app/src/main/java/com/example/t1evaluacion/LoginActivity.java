package com.example.t1evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.t1evaluacion.view.ContainerActivity;
import com.example.t1evaluacion.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    //DECLARAMOS LAS VISTAS QUE NECESITAMOS
    private EditText emailField, passwordField;
    private ToggleButton toggleRol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //INITIALIZATIONS LAS VISTAS
        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.password);
        toggleRol = findViewById(R.id.toogle_rol);

        //LOG PARA SABER SI LA ACTIVIDAD HA SIDO CREADA
        Log.d(TAG, "La Actividad ha sido Creada");

        //AJUSTE LOS INSETS PARA MANEJAR BARRAS DE SISTEMA
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //METODO PARA IR A LA PANTALLA PRINCIPAL
    public void goCreateAccount(View view) {

        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        boolean isClient = toggleRol.isChecked(); //SI ESTA ACTIVADO SIGNIFICA QUE EL USUARIO ES EL CLIENTE

        //SIMULACION DE VALIDACION DE CREDENCIALES

        if (email.equals("beny0123@gmail.com") && password.equals("1234") && !isClient) {
            // Ir a la actividad del cliente (ContainerActivity)
            Intent intent = new Intent(this, ContainerActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Iniciaste sesión como Repartidor", Toast.LENGTH_SHORT).show();

        } else if (email.equals("Antony1234@example.com") && password.equals("1234") && isClient) {
            // Ir a la actividad del repartidor (puedes cambiarlo si hay una actividad diferente para repartidores)
            Intent intent = new Intent(this, ContainerActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Iniciaste sesión como Cliente", Toast.LENGTH_SHORT).show();

        } else {
            // Mostrar mensaje de error si las credenciales no son correctas
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }


        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void goContainer(View view) {

        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();

        // Log message for onStart
        Log.d(TAG, "La Actividad ha Comenzado");
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Log message for onStop
        Log.d(TAG, "La Actividad ha sido Pausada");
    }
}