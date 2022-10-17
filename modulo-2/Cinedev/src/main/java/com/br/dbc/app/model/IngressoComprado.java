package com.br.dbc.app.model;

import java.time.LocalDateTime;

public class IngressoComprado {

    private  int idCliente;
    private int idIngressoComprado;
    private String nomeFilme;
    private String nomeCinema;
    private LocalDateTime DataHora;

    public IngressoComprado(){
    }

    public IngressoComprado(int idIngressoComprado, String nomeFilme, String nomeCinema, LocalDateTime dataHora) {
        this.idIngressoComprado = idIngressoComprado;
        this.nomeFilme = nomeFilme;
        this.nomeCinema = nomeCinema;
        DataHora = dataHora;
    }

    public int getIdIngressoComprado() {
        return idIngressoComprado;
    }

    public void setIdIngressoComprado(int idIngressoComprado) {
        this.idIngressoComprado = idIngressoComprado;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getNomeCinema() {
        return nomeCinema;
    }

    public void setNomeCinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
    }

    public LocalDateTime getDataHora() {
        return DataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        DataHora = dataHora;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Informações do Ingresso : " +
                "ID do Ingresso=" + idIngressoComprado +
                ", Filme ='" + nomeFilme + '\'' +
                ", Cinema ='" + nomeCinema + '\'' +
                ", Data e Horario =" + DataHora +
                '}';
    }
}
