package com.diegoppg.proyectotema3.patron.interfaces;


import android.util.Log;

import com.diegoppg.proyectotema3.patron.modelo.Ardilla;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class SqlArdilla implements InterfaceArdilla {

    @Override
    public void añadirArdilla(String nombre, String habitat, String color) {
        Log.d("SqlArdilla", "Añadiendo ardilla: " + nombre);
    }

    @Override
    public void eliminarArdilla(String nombre) {
        Log.d("SqlArdilla", "Eliminando ardilla: " + nombre);
    }

    @Override
    public CompletableFuture<ArrayList<Ardilla>> listarArdilla() {
        return CompletableFuture.completedFuture(new ArrayList<>());
    }
}
