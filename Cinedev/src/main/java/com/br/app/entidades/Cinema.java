package com.br.app.entidades;

import java.util.ArrayList;

public class Cinema {

    private String nome;
    private String estado;
    private String cidade;
    private ArrayList<Filme> filmes;

    public Cinema() {
    }

    public Cinema(String nome, String estado, String cidade) {
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
