package com.br.dbc.app.view.util;

public class FormatarTitulo {

    private FormatarTitulo() {
        throw new IllegalStateException("Classe útil");
    }

    public static String formatarTitulo(String titulo) {
        final int TAMANHO_TITULO = titulo.length();
        final int TAMANHO_MAXIMO = 60;
        final int x = TAMANHO_MAXIMO - TAMANHO_TITULO;
        int direita = 0;
        int esquerda = 0;

        final boolean isTamanhoTituloPar = TAMANHO_TITULO % 2 == 0;
        if (isTamanhoTituloPar) {
            direita = x / 2;
        } else {
            direita = (x / 2) - 2;
        }

        esquerda = x / 2;

        return "=".repeat(esquerda) + " " + titulo.toUpperCase() + " " + "=".repeat(direita);
    }
}
