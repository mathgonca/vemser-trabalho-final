package com.br.app.crud.impl;

import com.br.app.entidades.Cliente;
import com.br.app.entidades.Ingresso;
import com.br.app.entidades.enums.Disponibilidade;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ImplClienteCrudTest {

    @Test
    public void deveAdicionarUmNovoCliente() {
        final int TAMANHO_ESPERADO = 2;

        Cliente cliente01 = new Cliente("Maria", "Assis", "12345678900",
                23, "maria.assis@dbccompany.com.br");

        Cliente cliente02 = new Cliente("João", "Oliveira", "12345678911",
                27, "joao.oliveira@dbccompany");

        ImplClienteCrud clienteCrud = new ImplClienteCrud();
        boolean isCliente01Add = clienteCrud.adicionar(cliente01);
        boolean isCliente02Add = clienteCrud.adicionar(cliente02);

        int tamanhoDalista = clienteCrud.listarTodos().size();

        Assert.assertTrue(isCliente01Add);
        Assert.assertTrue(isCliente02Add);
        Assert.assertEquals(TAMANHO_ESPERADO, tamanhoDalista);
    }

    @Test
    public void naoDeveAdicionarDoisClientesComOMesmoCPF() {
        final int TAMANHO_ESPERADO = 1;

        Cliente cliente01 = new Cliente("Maria", "Assis", "12345678900",
                23, "maria.assis@dbccompany.com.br");

        Cliente cliente02 = new Cliente("João", "Oliveira", "12345678900",
                27, "joao.oliveira@dbccompany");

        ImplClienteCrud clienteCrud = new ImplClienteCrud();
        boolean isCliente01Add = clienteCrud.adicionar(cliente01);
        boolean isCliente02Add = clienteCrud.adicionar(cliente02);

        int tamanhoDalista = clienteCrud.listarTodos().size();

        Assert.assertTrue(isCliente01Add);
        Assert.assertFalse(isCliente02Add);
        Assert.assertEquals(TAMANHO_ESPERADO, tamanhoDalista);
    }

    @Test
    public void deveComprarUmIngressoDisponivel() {
        final int TAMANHO_ESPERADO = 1;

        Ingresso ingresso = new Ingresso(1, LocalDateTime.now());

        Cliente cliente = new Cliente("Maria", "Assis", "12345678900",
                23, "maria.assis@dbccompany.com.br");

        ImplClienteCrud clienteCrud = new ImplClienteCrud();
        boolean isIngressoAdd = clienteCrud.adicionarIngresso(cliente, ingresso);

        List<Ingresso> clienteIngressoList = cliente.getIngressos();

        Assert.assertTrue(isIngressoAdd);
        Assert.assertEquals(Disponibilidade.INDISPONIVEL, ingresso.getDisponibilidade());
        Assert.assertEquals(TAMANHO_ESPERADO, clienteIngressoList.size());
    }

    @Test
    public void naoDeveComprarUmIngressoIndisponivel() {
        final int TAMANHO_ESPERADO = 0;

        Ingresso ingresso = new Ingresso(1, LocalDateTime.now());
        ingresso.setDisponibilidade(Disponibilidade.INDISPONIVEL);

        Cliente cliente = new Cliente("Maria", "Assis", "12345678900",
                23, "maria.assis@dbccompany.com.br");

        ImplClienteCrud clienteCrud = new ImplClienteCrud();
        boolean isIngressoAdd = clienteCrud.adicionarIngresso(cliente, ingresso);

        List<Ingresso> clienteIngressoList = cliente.getIngressos();

        Assert.assertFalse(isIngressoAdd);
        Assert.assertEquals(Disponibilidade.INDISPONIVEL, ingresso.getDisponibilidade());
        Assert.assertEquals(TAMANHO_ESPERADO, clienteIngressoList.size());
    }
}
