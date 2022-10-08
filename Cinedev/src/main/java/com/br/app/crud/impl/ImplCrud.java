package com.br.app.crud.impl;

import com.br.app.crud.Crud;

import java.util.ArrayList;
import java.util.List;

public class ImplCrud<T> implements Crud<T> {

    List<T> valores = new ArrayList<>();

    @Override
    public boolean adicionar(T obj) {
        return valores.add(obj);
    }

    @Override
    public boolean remover(T obj) {
        return valores.remove(obj);
    }

    @Override
    public List<T> listarTodos() {
        return valores;
    }

    @Override
    public T listarPeloId(int i) {
        return valores.get(i);
    }
}
