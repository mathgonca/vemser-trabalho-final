package com.br.app.entidades.enums;

public enum Idioma {

    DUBLADO("DUB"), LEGENDADO("LEG");

    private final String idioma;

    Idioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }
}
