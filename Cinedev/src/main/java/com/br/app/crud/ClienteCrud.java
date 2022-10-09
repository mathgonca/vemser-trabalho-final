package com.br.app.crud;

import com.br.app.entidades.Cliente;
import com.br.app.entidades.Ingresso;

public interface ClienteCrud {

    public boolean adicionarIngresso(Cliente cliente, Ingresso ingresso);

}

