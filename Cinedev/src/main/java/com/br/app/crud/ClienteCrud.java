package com.br.app.crud;

import com.br.app.entidades.Cliente;
import com.br.app.entidades.Ingresso;

import java.util.List;

public interface ClienteCrud {

    public boolean adicionarIngresso(Cliente cliente, Ingresso ingresso);

<<<<<<< HEAD
=======
    public List<Ingresso> listaIngressosComprados(Cliente cliente);
>>>>>>> 7b5359e04cd1a3893882be9930dc8a302b35e8ab

    public Cliente encontrarClientePeloCPF(String cpf);
}

