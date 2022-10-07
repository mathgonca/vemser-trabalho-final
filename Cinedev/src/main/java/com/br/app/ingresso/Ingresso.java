package com.br.app.ingresso;

public class Ingresso {

    private int id;
    private int cadeira;
    private String dataHora;

    public Ingresso() {
    }

    public Ingresso(int id, int cadeira, String dataHora) {
        this.id = id;
        this.cadeira = cadeira;
        this.dataHora = dataHora;
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

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "id=" + id +
                ", cadeira=" + cadeira +
                ", dataHora='" + dataHora + '\'' +
                '}';
    }
}
