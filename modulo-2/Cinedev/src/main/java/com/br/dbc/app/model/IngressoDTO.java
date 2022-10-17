package com.br.dbc.app.model;

import java.time.LocalDateTime;

public class IngressoDTO {

    private int idIngressoDTO;
    private LocalDateTime dataHora;
    private double valor;

    public IngressoDTO() {
    }

    public IngressoDTO(int idIngressoDTO, LocalDateTime dataHora, double valor) {
        this.idIngressoDTO = idIngressoDTO;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public int getIdIngressoDTO() {
        return idIngressoDTO;
    }

    public void setIdIngressoDTO(int idIngressoDTO) {
        this.idIngressoDTO = idIngressoDTO;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "IngressoDTO{" +
                "idIngressoDTO=" + idIngressoDTO +
                ", dataHora=" + dataHora +
                ", valor=" + valor +
                '}';
    }
}
