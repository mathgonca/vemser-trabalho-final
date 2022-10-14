package com.br.app.crud;

import java.util.List;

public interface Crud<T> {

    public boolean adicionar(T obj);

    public boolean remover(T obj);

    public List<T> listarTodos();

    public T listarPeloId(int i);

    public void update(int i, T obj);
}
