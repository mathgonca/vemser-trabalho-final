package com.br.app.crud.impl;

import com.br.app.crud.ClienteCrud;
import com.br.app.entidades.Cliente;
import com.br.app.entidades.Ingresso;
import com.br.app.entidades.enums.Disponibilidade;

import java.util.List;
import java.util.Optional;

public class ImplClienteCrud extends ImplCrud<Cliente> implements ClienteCrud {

    @Override
    public boolean adicionar(Cliente cliente) {
        String cpf = cliente.getCpf();

        List<Cliente> clienteList = this.listarTodos();
        Optional<Cliente> clienteRetorno = clienteList.stream()
                .filter(cliente1 -> cliente1.getCpf().equals(cpf))
                .findFirst();

        if (clienteRetorno.isEmpty()) {
            return valores.add(cliente);
        } else {
            return false;
        }
    }

    @Override
    public boolean adicionarIngresso(Cliente cliente, Ingresso ingresso) {
        if(ingresso.getDisponibilidade() == Disponibilidade.DISPONIVEL) {
            ingresso.setDisponibilidade(Disponibilidade.INDISPONIVEL);

            List<Ingresso> ingressoList = cliente.getIngressos();
            ingressoList.add(ingresso);

            cliente.setIngressos(ingressoList);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Ingresso> listaIngressosComprados(Cliente cliente) {
        return cliente.getIngressos();
    }
}
