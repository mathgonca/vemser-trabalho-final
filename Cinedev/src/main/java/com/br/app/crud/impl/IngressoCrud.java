package com.br.app.crud.impl;

import com.br.app.entidades.Ingresso;

import java.util.List;
import java.util.Optional;

public class IngressoCrud extends ImplCrud<Ingresso> {

    @Override
    public boolean adicionar(Ingresso ingresso) {
        int cadeira = ingresso.getCadeira();

        List<Ingresso> ingressoList = this.listarTodos();
        Optional<Ingresso> ingressoRetorno = ingressoList.stream()
                .filter(ingresso1 -> ingresso1.getCadeira() == cadeira)
                .findFirst();

        if (ingressoRetorno.isEmpty()) {
            return valores.add(ingresso);
        } else {
            return false;
        }
    }
}
