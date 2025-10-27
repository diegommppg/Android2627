package com.diegoppg.ejemploandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginCorrecto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_correcto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonAlarma = findViewById(R.id.buttonAlarma);
        TextView textViewBienvenido = findViewById(R.id.textViewBienvenido);
        ImageButton imageButtonNavegador = findViewById(R.id.imageButtonNavegador);

        Intent intentPadre = getIntent();
        String nombre = intentPadre.getStringExtra("nombre");

        //Modificar texto etiqueta
        textViewBienvenido.setText("Bienvenido: " + nombre);

        //Intent a actividad Alarma
        buttonAlarma.setOnClickListener(v -> {
            Intent intentAlarma = new Intent(this, Alarma.class);
            startActivity(intentAlarma);
        });


        //Intent a navegador
        imageButtonNavegador.setOnClickListener(v -> {
            Intent intentNavegador = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.tutorialspoint.com/android/android_intents_filters.htm"));
            startActivity(intentNavegador);
        });

    }
}