package com.example.t1evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.t1evaluacion.view.ContainerActivity;
import com.example.t1evaluacion.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        //Log message for onCreate
        Log.d(TAG, "La Actividad ha sido Creada");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goCreateAccount(View view) {

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