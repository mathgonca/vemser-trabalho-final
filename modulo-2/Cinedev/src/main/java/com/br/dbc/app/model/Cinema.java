package com.br.dbc.app.model;

public class Cinema {

    private Integer idCinema;
    private String nome;
    private String estado;
    private String cidade;

    public Cinema(int i, String nome, String estado, String cidade) {
    }

    public Cinema() {

    }


    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Integer idCinema) {
        this.idCinema = idCinema;
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
        return "id=" + idCinema  +
                ", nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'';
    }

    public CharSequence getCpf() {
        return null;
    }
}
