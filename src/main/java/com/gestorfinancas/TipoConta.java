package com.gestorfinancas;

public enum TipoConta {
    CORRENTE(1),
    POUPANCA(2);

    private final Integer type;

    TipoConta(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
