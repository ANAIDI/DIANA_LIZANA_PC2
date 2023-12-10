package com.lizana.enums;

public enum CategoriaEvento {
    PLATINUM(500),
    GOLD(350),
    SILVER(100);

    private final int costo;

    CategoriaEvento(int costo) {
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }


}
