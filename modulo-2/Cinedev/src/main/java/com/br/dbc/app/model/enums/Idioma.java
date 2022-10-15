package com.br.dbc.app.model.enums;

public enum Idioma {

    DUBLADO("DUBLADO"), LEGENDADO("LEGENDADO");

    private final String idioma;

    Idioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }


}
