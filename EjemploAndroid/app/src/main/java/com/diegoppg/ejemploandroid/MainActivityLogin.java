package com.diegoppg.ejemploandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class MainActivityLogin extends AppCompatActivity {

    String user = "admin";
    String pass = "admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonModify = findViewById(R.id.buttonModify);
        EditText editTextNombre = findViewById(R.id.editTextNombre);
        EditText editTextPass = findViewById(R.id.editTextPass);


        SharedPreferences sharedPref = getSharedPreferences("MiPreferencia", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("nombreUsuario", "Juan");
        editor.putBoolean("logueado", true);

// Guarda los cambios
        editor.apply(); // o editor.commit();



        //ImageView imageView = findViewById(R.id.imageViewTest);


        //Glide.with(this).load("https://goo.gl/gEgYUd").into(imageView);

        /*Glide.with(this)
                .load(url)
                .placeholder(R.drawable.ic_placeholder) // imagen mientras carga
                .error(R.drawable.ic_error) // imagen si ocurre un error
                .apply(RequestOptions.circleCropTransform()) // transforma en imagen circular
                .into(imageViewFoto);
        */


        //Result Launcher cuando se modifica el usuario y contraseña desde otr actividad
        ActivityResultLauncher<Intent> activityResultModificar =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result -> {
            if(result.getResultCode() == Activity.RESULT_OK){
                Intent intentLogin = result.getData();
                String nuevoNombre = intentLogin.getStringExtra("nuevo_nombre");
                String nuevoPass = intentLogin.getStringExtra("nuevo_pass");
                user = nuevoNombre;
                pass = nuevoPass;
            }
            else if(result.getResultCode() == Activity.RESULT_CANCELED){
                Toast.makeText(this, "Modificacion cancelada", Toast.LENGTH_SHORT).show();
            }
        });

        buttonModify.setOnClickListener(v -> {
            SharedPreferences sharedPref2 = getSharedPreferences("MiPreferencia", MODE_PRIVATE);

            String nombre = sharedPref2.getString("nombreUsuario", "Invitado");
            boolean logueado = sharedPref2.getBoolean("logueado", false);

            Log.d("SharedPref", "Usuario: " + nombre + ", Logueado: " + logueado);


            Intent intentMofificar = new Intent(this, ModificarCredenciales.class);
            activityResultModificar.launch(intentMofificar);
        });








        buttonLogin.setOnClickListener(v -> {
            String nombreText = editTextNombre.getText().toString();
            String passText = editTextPass.getText().toString();

            if(nombreText.equals(user) && passText.equals(pass)){
                Intent intentLogin = new Intent(this, LoginCorrecto.class);
                intentLogin.putExtra("nombre", nombreText);
                startActivity(intentLogin); //Inicia la actividad LoginCorrecto
            }
            else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });





    }
}