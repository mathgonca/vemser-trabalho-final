package com.br.app.crud.impl;

import com.br.app.entidades.Ingresso;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class IngressoCrud extends ImplCrud<Ingresso> {

    @Override
    public boolean adicionar(Ingresso ingresso) {
        int id = valores.size();

        int cadeira = ingresso.getCadeira();
        String filme = ingresso.getFilme().getNome();
        LocalDateTime dataHora = ingresso.getDataHora();

        List<Ingresso> ingressoList = this.listarTodos();
        Optional<Ingresso> ingressoRetorno = ingressoList.stream()
                .filter(ingresso1 -> ingresso1.getCadeira() == cadeira
                        && ingresso1.getDataHora() == dataHora
                        && ingresso1.getFilme().getNome() == filme)
                .findFirst();

        if (ingressoRetorno.isEmpty()) {
            ingresso.setId(id);
            return valores.add(ingresso);
        } else {
            return false;
        }
    }

    public boolean update(Ingresso ingresso) {
        int id = (ingresso.getId());

        valores.set(id, ingresso);

        return true;
    }

    public Optional<Ingresso> listarPorId(int id) {
        return valores.stream()
                .filter(ingresso -> ingresso.getId() == id)
                .findFirst();
    }
}
