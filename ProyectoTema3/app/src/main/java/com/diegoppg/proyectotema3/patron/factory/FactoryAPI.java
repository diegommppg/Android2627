package com.diegoppg.proyectotema3.patron.factory;

public class FactoryAPI {
    public static AbstractFactory getFactory(String factoryType) {
        if (factoryType.equals("SQL")) {
            return new SqlFactory();
        } else {
            return null;
        }
    }
}
