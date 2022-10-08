package com.br.app.crud.impl;

import com.br.app.entidades.Filme;
import com.br.app.entidades.Ingresso;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class IngressoCrudTest {

    @Test
    public void deveCadastrarIngresso() {
        Filme filme = new Filme();
        Ingresso ingresso = new Ingresso(0, LocalDateTime.now(), filme);

        IngressoCrud crud = new IngressoCrud();
        boolean isIngressoAdd = crud.adicionar(ingresso);

        Assert.assertTrue(isIngressoAdd);
    }

    @Test
    public void naoDeveCadastrarIngressosComCadeiraIguais() {
        Filme filme = new Filme();

        Ingresso ingresso01 = new Ingresso(0, LocalDateTime.now(), filme);
        Ingresso ingresso02 = new Ingresso(0, LocalDateTime.now(), filme);

        IngressoCrud crud = new IngressoCrud();
        boolean isIngresso01Add = crud.adicionar(ingresso01);
        boolean isIngresso02Add = crud.adicionar(ingresso02);

        Assert.assertTrue(isIngresso01Add);
        Assert.assertFalse(isIngresso02Add);
    }
}
