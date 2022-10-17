package com.br.dbc.app.model.enums;

public enum Disponibilidade {
    S("S"), N("N");

    private final String disponibilidade;

    Disponibilidade(String descricao) {
        this.disponibilidade = descricao;
    }

    public String isDisponibilidade() {
        return disponibilidade;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }
}
