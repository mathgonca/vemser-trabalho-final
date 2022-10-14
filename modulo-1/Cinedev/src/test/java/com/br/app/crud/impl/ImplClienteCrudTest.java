package com.br.app.crud.impl;

import com.br.app.entidades.Cliente;
import com.br.app.entidades.Filme;
import com.br.app.entidades.Ingresso;
import com.br.app.entidades.enums.Disponibilidade;
import com.br.app.entidades.enums.Idioma;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
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

        Cliente cliente = new Cliente("Maria", "Assis", "12345678900",
                23, "maria.assis@dbccompany.com.br");

        ImplClienteCrud clienteCrud = new ImplClienteCrud();
        clienteCrud.adicionar(cliente);

        Filme filme = new Filme();
        Ingresso ingresso = new Ingresso(1, LocalDateTime.now(), filme);

        boolean isIngressoAdd = clienteCrud.adicionarIngresso(cliente, ingresso);

        List<Ingresso> clienteIngressoList = cliente.getIngressos();

        Assert.assertTrue(isIngressoAdd);
        Assert.assertEquals(Disponibilidade.INDISPONIVEL, ingresso.getDisponibilidade());
        Assert.assertEquals(TAMANHO_ESPERADO, clienteIngressoList.size());
    }

    @Test
    public void naoDeveComprarUmIngressoIndisponivel() {
        final int TAMANHO_ESPERADO = 0;

        Filme filme = new Filme();
        Ingresso ingresso = new Ingresso(1, LocalDateTime.now(), filme);
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

    @Test
    public void listaIngressosComprados() {
        Filme filme01 = new Filme("Vingadores: Ultimato", Idioma.LEGENDADO, 12, 182);
        Filme filme02 = new Filme("Homem-Aranha: Sem Volta para Casa", Idioma.LEGENDADO, 12, 157);
        Filme filme03 = new Filme("Batman", Idioma.DUBLADO, 14, 176);

        Ingresso ingresso01 = new Ingresso(1, LocalDateTime.now(), filme01);
        Ingresso ingresso02 = new Ingresso(3, LocalDateTime.now(), filme02);
        Ingresso ingresso03 = new Ingresso(10, LocalDateTime.now(), filme03);

        Cliente cliente = new Cliente("Maria", "Assis", "12345678900",
                23, "maria.assis@dbccompany.com.br");

        ImplClienteCrud crud = new ImplClienteCrud();
        crud.adicionar(cliente);

        crud.adicionarIngresso(cliente, ingresso01);
        crud.adicionarIngresso(cliente, ingresso02);
        crud.adicionarIngresso(cliente, ingresso03);

        List<Ingresso> ingressoList =  crud.listaIngressosComprados(cliente);
        ingressoList.stream()
                .forEach(System.out::println);
    }
}
