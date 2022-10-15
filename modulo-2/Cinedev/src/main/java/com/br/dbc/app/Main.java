package com.br.dbc.app;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.model.Filme;
import com.br.dbc.app.model.enums.Idioma;
import com.br.dbc.app.repository.CinemaRepository;
import com.br.dbc.app.repository.FilmeRepository;
import com.br.dbc.app.service.FilmeService;

public class Main {
    public static void main(String[] args) throws BancoDeDadosException {

        FilmeService filme = new FilmeService();

        Filme filme1 = new Filme();
        filme1.setNome("Man of Steel");
        filme1.setIdioma(Idioma.DUBLADO);
        filme1.setClassificacaoEtaria(13);
        filme1.setDuracao(168);
        filme.adicionarFilme(filme1);
        filme.listarFilmes();




    }
}