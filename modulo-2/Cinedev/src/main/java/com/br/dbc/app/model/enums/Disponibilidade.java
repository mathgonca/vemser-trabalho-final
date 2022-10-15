package com.br.dbc.app.model.enums;

public enum Disponibilidade {
    DISPONIVEL("S"), INDISPONIVEL("N");

    private final String disponibilidade;

    Disponibilidade(String descricao) {
        this.disponibilidade = descricao;
    }

    public String isDisponibilidade() {
        return disponibilidade;
    }
}
