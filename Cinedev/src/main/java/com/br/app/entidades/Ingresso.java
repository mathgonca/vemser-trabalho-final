package com.br.app.entidades;

import com.br.app.entidades.enums.Disponibilidade;

import java.time.LocalDateTime;

public class Ingresso {

    private int cadeira;
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

    public int getCadeira() {
        return cadeira;
    }

    public void setCadeira(int cadeira) {
        this.cadeira = cadeira;
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
                "cadeira=" + cadeira +
                ", dataHora=" + dataHora +
                ", filme=" + filme +
                '}';
    }
}
