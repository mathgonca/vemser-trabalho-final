package com.br.dbc.app.model;

import com.br.dbc.app.model.enums.Disponibilidade;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ingresso {

    private Integer idIngresso;
    private int cadeira;
    private double preco;
    private LocalDateTime dataHora;
    private Disponibilidade disponibilidade;
    private int idFilme;
    private int idCinema;
    private int idCliente;


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

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;

    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente cliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "idIngresso=" + idIngresso +
                ", cadeira=" + cadeira +
                ", preco=" + preco +
                ", dataHora=" + dataHora +
                ", disponibilidade=" + disponibilidade +
                '}';

    }
}
