package com.diegoppg.macandroid;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        /*
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Despierta")
                .putExtra(AlarmClock.EXTRA_HOUR, 9)
                .putExtra(AlarmClock.EXTRA_MINUTES, 0);

        startActivity(intent);
        */
        final String userName = "admin";
        final String userPass = "1234";

        Button btnLogin = findViewById(R.id.btnLogin);
        final EditText editTextNombre = findViewById(R.id.editTextNombre);
        final EditText editTextPass = findViewById(R.id.editTextPass);

        btnLogin.setOnClickListener(v -> {

            String user = editTextNombre.getText().toString();
            String pass = editTextPass.getText().toString();

            if(user.equals(userName) && pass.equals(userPass)){
                Intent intent = new Intent(this, ProfileActivity.class);

                intent.putExtra("Nickname", user);

                startActivity(intent);
            }

            else{
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d("DAM", "Se ha ejecutado el onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        // Start playing media
        Log.d("DAM", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save data, stop background processes
        Log.d("DAM", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Release resources
        Log.d("DAM", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Restore state
        Log.d("DAM", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release all resources
        Log.d("DAM", "onDestroy");
    }

}