package com.br.app.crud.impl;

import com.br.app.entidades.Cinema;
import org.junit.Assert;
import org.junit.Test;

public class CinemaCrudTest {

    @Test
    public void deveAdicionarUmNovoCinema() {
        CinemaCrud crud = new CinemaCrud();

        Cinema cinema = new Cinema("GNC Praia de Belas", "Rio Grande do Sul", "Porto Alegre");

        boolean isCinemaAdd = crud.adicionar(cinema);

        Assert.assertTrue(isCinemaAdd);
    }

    @Test
    public void naoDeveAdicionarDoisCinemasComOMesmoNome() {
        CinemaCrud crud = new CinemaCrud();

        Cinema cinema01 = new Cinema("GNC Praia de Belas", "Rio Grande do Sul", "Porto Alegre");
        Cinema cinema02 = new Cinema("GNC Praia de Belas", "Rio Grande do Sul", "Porto Alegre");

        boolean isCinema01Add = crud.adicionar(cinema01);
        boolean isCinema02Add = crud.adicionar(cinema02);

        Assert.assertTrue(isCinema01Add);
        Assert.assertFalse(isCinema02Add);
    }
}
