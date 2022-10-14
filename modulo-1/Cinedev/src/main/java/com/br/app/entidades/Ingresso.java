package com.br.app.entidades;

import com.br.app.entidades.enums.Disponibilidade;

import java.time.LocalDateTime;

public class Ingresso {

    private int id;
    private int cadeira;
    private double preco;
    private LocalDateTime dataHora;
    private Disponibilidade disponibilidade;
    private Filme filme;

    public Ingresso() {
    }

    public Ingresso(int cadeira, LocalDateTime dataHora, Filme filme) {
        this.cadeira = cadeira;
        this.dataHora = dataHora;
        this.disponibilidade = Disponibilidade.DISPONIVEL;
        this.filme = filme;
    }

    public Ingresso(int cadeira, double preco, LocalDateTime dataHora, Filme filme) {
        this.cadeira = cadeira;
        this.preco = preco;
        this.dataHora = dataHora;
        this.disponibilidade = Disponibilidade.DISPONIVEL;
        this.filme = filme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCadeira() {
        return cadeira;
    }

    public void setCadeira(int cadeira) {
        this.cadeira = cadeira;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "id=" + id +
                ", cadeira=" + cadeira +
                ", preco=" + preco +
                ", dataHora=" + dataHora +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
