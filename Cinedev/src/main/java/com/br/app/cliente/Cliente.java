package com.br.app.cliente;

import com.br.app.ingresso.Ingresso;

import java.util.ArrayList;

public class Cliente {

    private int id;
    private String primeiroNome;
    private String ultimoNome;
    private String cpf;
    private int idade;
    private String email;
    private ArrayList<Ingresso> ingressos;

    public Cliente() {
    }

    public Cliente(int id, String primeiroNome, String ultimoNome, String cpf, int idade, String email) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                '}';
    }
}
