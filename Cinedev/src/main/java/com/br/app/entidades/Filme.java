package com.br.app.entidades;

import com.br.app.entidades.enums.Idioma;

import java.util.ArrayList;

public class Filme {

    private String nome;
    private Idioma idioma;

    private int classificacaoEtaria;
    private int duracao;

    public Filme() {
    }

    public Filme(String nome, Idioma idioma, int classificacaoEtaria, int duracao) {
        this.nome = nome;
        this.idioma = idioma;
        this.classificacaoEtaria = classificacaoEtaria;
        this.duracao = duracao;
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

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", idioma=" + idioma +
                ", classificacaoEtaria=" + classificacaoEtaria +
                ", duracao=" + duracao +
                '}';
    }
}
