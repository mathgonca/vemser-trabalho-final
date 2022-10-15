package com.br.dbc.app.model;

import com.br.dbc.app.model.enums.Disponibilidade;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Ingresso {

    private Integer idIngresso;
    private int cadeira;
    private double preco;
    private Timestamp dataHora;
    private Disponibilidade disponibilidade;
    private Filme filme;
    private Cinema cinema;
    private Cliente cliente;


    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(Integer id) {
        this.idIngresso = id;
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

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
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

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "id=" + idIngresso +
                ", cadeira=" + cadeira +
                ", preco=" + preco +
                ", dataHora=" + dataHora +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
