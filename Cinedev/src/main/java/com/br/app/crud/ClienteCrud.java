package com.br.app.crud;

import com.br.app.entidades.Cliente;
import com.br.app.entidades.Ingresso;

import java.util.List;

public interface ClienteCrud {

    public boolean adicionarIngresso(Cliente cliente, Ingresso ingresso);

    public List<Ingresso> listaIngressosComprados(Cliente cliente);

    public Cliente encontrarClientePeloCPF(String cpf);
}

