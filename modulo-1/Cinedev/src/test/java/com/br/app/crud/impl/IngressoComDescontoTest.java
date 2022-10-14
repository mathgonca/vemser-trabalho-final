package com.br.app.crud.impl;

import com.br.app.entidades.IngressoComDesconto;
import org.junit.Assert;
import org.junit.Test;

public class IngressoComDescontoTest {

    @Test
    public void deveAdicionarUmDescontoAoValorDoIngresso() {
        final double PRECO_ESPERADO =  15;

        IngressoComDesconto ingressoComDesconto = new IngressoComDesconto();
        ingressoComDesconto.setPreco(30);

        boolean isDescontoAdicionado = ingressoComDesconto.adicionarDesconto(50);
        double precoAtualizado = ingressoComDesconto.getPreco();

        Assert.assertTrue(isDescontoAdicionado);
        Assert.assertEquals(PRECO_ESPERADO, precoAtualizado, 0.1);
    }

    @Test
    public void naoDeveAdicionarUmDescontoMenorOuIgualAZero() {
        IngressoComDesconto ingressoComDesconto = new IngressoComDesconto();
        ingressoComDesconto.setPreco(30);

        boolean isDescontoZero = ingressoComDesconto.adicionarDesconto(0);
        boolean isDescontoNegativo = ingressoComDesconto.adicionarDesconto(-15);

        Assert.assertFalse(isDescontoZero);
        Assert.assertFalse(isDescontoNegativo);
    }

    @Test
    public void naoDeveAdicionarUmDescontoMaiorQue100() {
        IngressoComDesconto ingressoComDesconto = new IngressoComDesconto();
        ingressoComDesconto.setPreco(30);

        boolean isDescontoAdicionado = ingressoComDesconto.adicionarDesconto(101);

        Assert.assertFalse(isDescontoAdicionado);
    }
}
