package com.diegoppg.proyectotema3.patron.interfaces;

import com.diegoppg.proyectotema3.patron.modelo.Ardilla;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public interface InterfaceArdilla {

    public void añadirArdilla(String nombre, String habitat, String color);
    public void eliminarArdilla(String nombre);
    public CompletableFuture<ArrayList<Ardilla>> listarArdilla();

}
