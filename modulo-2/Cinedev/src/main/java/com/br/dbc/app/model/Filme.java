package com.br.dbc.app.model;

import com.br.dbc.app.model.enums.Idioma;

import java.util.ArrayList;

public class Filme {

    private int id;
    private String nome;
    private Idioma idioma;

    private int classificacaoEtaria;
    private int duracao;

    public Filme() {
    }

    public Filme(String nome, Idioma idioma, int classificacaoIndicativa, int duracao) {
        this.nome = nome;
        this.idioma = idioma;
        this.classificacaoEtaria = classificacaoIndicativa;
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public int getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(int classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }


    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idioma=" + idioma +
                ", classificacaoEtaria=" + classificacaoEtaria +
                ", duracao=" + duracao +
                '}';
    }
}
