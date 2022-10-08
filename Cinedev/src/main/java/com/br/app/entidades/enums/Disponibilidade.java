package com.br.app.entidades.enums;

public enum Disponibilidade {
    DISPONIVEL(true), INDISPONIVEL(false);

    private final boolean descricao;

    Disponibilidade(boolean descricao) {
        this.descricao = descricao;
    }
}
