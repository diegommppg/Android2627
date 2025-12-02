package com.diegoppg.proyectotema3.patron.factory;

import com.diegoppg.proyectotema3.patron.interfaces.InterfaceArdilla;
import com.diegoppg.proyectotema3.patron.interfaces.SqlArdilla;

public class SqlFactory implements AbstractFactory{

    @Override
    public InterfaceArdilla getInterfaceArdilla() {
        return new SqlArdilla();
    }
}
