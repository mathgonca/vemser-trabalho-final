package com.br.app.cinema;

import com.br.app.filme.Filme;

import java.util.ArrayList;

public class Cinema {

    private int id;
    private String nome;
    private String estado;
    private String cidade;
    private ArrayList<Filme> filmes;

    public Cinema() {
    }

    public Cinema(int id, String nome, String estado, String cidade) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
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
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
