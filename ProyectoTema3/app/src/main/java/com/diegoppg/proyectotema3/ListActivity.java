package com.diegoppg.proyectotema3;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.listaCalvos);

        //Modelo
        String [] nombresCalvo ={
                "Homer", "Don limpio", "Paco Sanz", "Lobato"
        };

        Integer [] imagenesCalvo = {
                R.drawable.homer,
                R.drawable.donlimpio,
                R.drawable.pacosanz,
                R.drawable.lobato
        };

        ArrayList<HashMap<String, Object>> listaCalvos = new ArrayList<>();

        for(int i = 0; i < nombresCalvo.length; i++) {
            HashMap<String, Object> calvo = new HashMap<>();
            calvo.put("textViewNombreCalvo", nombresCalvo[i]);
            calvo.put("imageViewCalvo", imagenesCalvo[i]);
            listaCalvos.add(calvo);
        }


        //Crear adaptador
        String [] from = {"textViewNombreCalvo", "imageViewCalvo"};
        int [] to = {R.id.textViewNombreCalvo, R.id.imageViewCalvo};
        SimpleAdapter adapter = new SimpleAdapter(this, listaCalvos,
                R.layout.calvo_list, from, to);

        //Setear el adaptador
        listView.setAdapter(adapter);



    }
}