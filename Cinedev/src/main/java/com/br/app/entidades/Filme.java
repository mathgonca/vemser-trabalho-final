package com.br.app.entidades;

import com.br.app.entidades.enums.Idioma;

import java.util.ArrayList;

public class Filme {

    private String nome;
    private Idioma idioma;

    private int classificacaoEtaria;
    private int duracao;
    private ArrayList<Ingresso> ingressos;

    public Filme(String s, String dublado, String s1, String s2) {
    }

    public Filme(String nome, Idioma idioma, int classificacaoIndicativa, int duracao) {
        this.nome = nome;
        this.idioma = idioma;
        this.classificacaoEtaria = classificacaoIndicativa;
        this.duracao = duracao;
    }

    public static void nome() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
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
        return "Filme {" +
                "nome: '" + nome + '\'' +
                ", idioma: " + idioma +
                ", classificacaoIndicativa: " + classificacaoEtaria +
                ", duracao: " + duracao +
                '}';
    }
}
