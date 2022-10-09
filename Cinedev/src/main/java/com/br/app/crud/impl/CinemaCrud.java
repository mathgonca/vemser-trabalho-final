package com.br.app.crud.impl;

import com.br.app.crud.impl.ImplCrud;
import com.br.app.entidades.Cinema;

import java.util.List;
import java.util.Optional;

public class CinemaCrud extends ImplCrud<Cinema> {

    @Override
    public boolean adicionar(Cinema cinema) {
        String nome = cinema.getNome();

        List<Cinema> cinemaList = this.listarTodos();
        Optional<Cinema> cinemaRetorno = cinemaList.stream()
                .filter(cinema1 -> cinema1.getNome().equals(nome))
                .findFirst();

        if (cinemaRetorno.isEmpty()) {
            return valores.add(cinema);
        } else {
            return false;
        }
    }
}
