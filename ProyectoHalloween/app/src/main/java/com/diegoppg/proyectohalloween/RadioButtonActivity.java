package com.diegoppg.proyectohalloween;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        RadioButton radioButtonConPatatas = findViewById(R.id.radioButtonConPatatas);
        RadioButton radioButtonSinPatatas = findViewById(R.id.radioButtonSinPatatas);
        RadioGroup radioGroupPatatas = findViewById(R.id.radioGroupPatatas);
        Button buttonComprar = findViewById(R.id.buttonComprar);


        /*
        //Primer ejemplo: añadir listener a RadioButton
        radioButtonConPatatas.setOnClickListener((v) -> {
            Toast.makeText(this, "Has seleccionado con patatas", Toast.LENGTH_SHORT).show();
        });

        radioButtonSinPatatas.setOnClickListener((v) -> {
            Toast.makeText(this, "Has seleccionado sin patatas", Toast.LENGTH_SHORT).show();
        });

        //Segundo ejemplo: añadir mismo listener a varios radioButtons
        View.OnClickListener listenerPatatas = (v) -> {
            if (v.getId() == R.id.radioButtonConPatatas) {
                Toast.makeText(this, "Has seleccionado con patatas", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Has seleccionado sin patatas", Toast.LENGTH_SHORT).show();
            }
        };

        radioButtonConPatatas.setOnClickListener(listenerPatatas);
        radioButtonSinPatatas.setOnClickListener(listenerPatatas);
        */

        //Tercer ejemplo: añadir listener al RadioGroup
        radioGroupPatatas.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButtonConPatatas) {
                Toast.makeText(this, "Has seleccionado con patatas", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Has seleccionado sin patatas", Toast.LENGTH_SHORT).show();
            }
        });

        //Cuarto ejemplo: obtener opcion radio button desde botn clicado
        buttonComprar.setOnClickListener((v) -> {
            //radioButtonConPatatas.isChecked
            if(radioGroupPatatas.getCheckedRadioButtonId() == R.id.radioButtonConPatatas){
                Toast.makeText(this, "Has seleccionado con patatas", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Has seleccionado sin patatas", Toast.LENGTH_SHORT).show();
            }

            //RadioButton opcion = findViewById(radioGroupPatatas.getCheckedRadioButtonId());
            //Toast.makeText(this, "Has seleccionado " + opcion.getText(), Toast.LENGTH_SHORT).show();
        });


    }



}