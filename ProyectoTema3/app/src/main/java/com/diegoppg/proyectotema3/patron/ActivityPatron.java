package com.diegoppg.proyectotema3.patron;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.diegoppg.proyectotema3.R;
import com.diegoppg.proyectotema3.patron.factory.FactoryAPI;

import java.util.ArrayList;

public class ActivityPatron extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patron);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        FactoryAPI.getFactory(getString(R.string.database)).
                getInterfaceArdilla().listarArdilla().thenAccept(
                        ardillas -> {
                            System.out.println(ardillas);
                        }
                );



    }
}