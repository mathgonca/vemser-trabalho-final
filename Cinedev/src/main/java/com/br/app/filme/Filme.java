package com.br.app.filme;

import com.br.app.filme.enums.Idioma;
import com.br.app.ingresso.Ingresso;

import java.util.ArrayList;

public class Filme {

    private int id;
    private String nome;
    private Idioma idioma;

    private int classificacaoEtaria;
    private int duracao;
    private ArrayList<Ingresso> ingressos;

    public Filme() {
    }

    public Filme(int id, String nome, Idioma idioma, int classificacaoEtaria, int duracao) {
        this.id = id;
        this.nome = nome;
        this.idioma = idioma;
        this.classificacaoEtaria = classificacaoEtaria;
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

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
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
