package com.br.app.entidades.enums;

public enum Idioma {

    DUBLADO("DUB"), LEGENDADO("LEG");

    private final String descricao;

    Idioma(String descricao) {
        this.descricao = descricao;
    }
}
