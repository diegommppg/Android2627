package com.diegoppg.ejemploandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ModificarCredenciales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar_credenciales);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonGuardar = findViewById(R.id.buttonGuardar);
        EditText editTextNombre = findViewById(R.id.editTextNombre);
        EditText editTextPass = findViewById(R.id.editTextPass);

        buttonGuardar.setOnClickListener(v -> {
            Intent intentLogin = getIntent();
            intentLogin.putExtra("nuevo_nombre", editTextNombre.getText().toString());
            intentLogin.putExtra("nuevo_pass", editTextPass.getText().toString());

            //Setear el resultado a OK
            setResult(Activity.RESULT_OK, intentLogin);

            //Terminar la actividad
            finish();

        });

    }
}