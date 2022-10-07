package com.br.app;

import com.br.app.cinema.Cinema;
import com.br.app.filme.Filme;
import com.br.app.filme.enums.Idioma;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Cinema cinema = new Cinema(0, "Cinemark Barra Sul", "Rio Grande do Sul", "Porto Alegre");

        Filme filme01 = new Filme(0, "Não Se Preocupe, Querida", Idioma.LEGENDADO, 16, 123);
        Filme filme02 = new Filme(1, "Mais Que Amigos", Idioma.LEGENDADO, 16, 116);
        Filme filme03 = new Filme(2, "As Aventuras de Tadeo", Idioma.DUBLADO, 0, 90);

        ArrayList<Filme> filmes = new ArrayList<>();
        filmes.add(filme01);
        filmes.add(filme02);
        filmes.add(filme03);

        cinema.setFilmes(filmes);

    }
}