package com.br.app.crud.impl;

import com.br.app.crud.impl.ImplCrud;
import com.br.app.entidades.Filme;

public class FilmeCrud extends ImplCrud<Filme> {

    @Override
    public boolean adicionar(Filme filme) {
        int id = valores.size();

        filme.setId(id);
        return valores.add(filme);
    }
}
