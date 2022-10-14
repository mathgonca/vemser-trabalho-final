package com.br.dbc.app.model;

public class Cinema {

    private int id;
    private String nome;
    private String estado;
    private String cidade;

    public Cinema() {
    }

    public Cinema(String nome, String estado, String cidade) {
        this.id = 0;
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

    @Override
    public String toString() {
        return "id=" + id  +
                ", nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'';
    }
}
