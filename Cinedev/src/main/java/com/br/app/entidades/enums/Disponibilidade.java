package com.br.app.entidades.enums;

public enum Disponibilidade {
    DISPONIVEL(true), INDISPONIVEL(false);

    private final boolean disponibilidade;

    Disponibilidade(boolean descricao) {
        this.disponibilidade = descricao;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }
}
