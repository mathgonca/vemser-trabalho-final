package com.br.app.crud.impl;

import com.br.app.entidades.Filme;
import com.br.app.entidades.Ingresso;
import com.br.app.entidades.enums.Idioma;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    public void deveCadastrarIngressosComMesmaCadeiraEMesmoFilmeEmHorariosDiferentes() {
        LocalDateTime time01 = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 45));
        LocalDateTime time02 = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(15, 45));

        Filme filme01 = new Filme("Vingadores: Ultimato", Idioma.LEGENDADO, 12, 182);

        Ingresso ingresso01 = new Ingresso(0, time01, filme01);
        Ingresso ingresso02 = new Ingresso(0, time02, filme01);

        IngressoCrud crud = new IngressoCrud();
        boolean isIngresso01Add = crud.adicionar(ingresso01);
        boolean isIngresso02Add = crud.adicionar(ingresso02);

        Assert.assertTrue(isIngresso01Add);
        Assert.assertTrue(isIngresso02Add);
    }

    @Test
    public void deveCadatrarIngressosComCadeiraIguaisEFilmesDiferentes() {
        LocalDateTime time01 = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 45));

        Filme filme01 = new Filme("Vingadores: Ultimato", Idioma.LEGENDADO, 12, 182);
        Filme filme02 = new Filme("Homem-Aranha: Sem Volta para Casa", Idioma.LEGENDADO, 12, 157);

        Ingresso ingresso01 = new Ingresso(0, time01, filme01);
        Ingresso ingresso02 = new Ingresso(0, time01, filme02);

        IngressoCrud crud = new IngressoCrud();
        boolean isIngresso01Add = crud.adicionar(ingresso01);
        boolean isIngresso02Add = crud.adicionar(ingresso02);

        Assert.assertTrue(isIngresso01Add);
        Assert.assertTrue(isIngresso02Add);
    }

    @Test
    public void naoDeveCadastrarIngressosComCadeiraIguaisNoMesmoFilmeENaMesmaHora() {
        LocalDateTime time01 = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 45));

        Filme filme01 = new Filme("Vingadores: Ultimato", Idioma.LEGENDADO, 12, 182);

        Ingresso ingresso01 = new Ingresso(0, time01, filme01);
        Ingresso ingresso02 = new Ingresso(0, time01, filme01);
        IngressoCrud crud = new IngressoCrud();
        boolean isIngresso01Add = crud.adicionar(ingresso01);
        boolean isIngresso02Add = crud.adicionar(ingresso02);

        Assert.assertTrue(isIngresso01Add);
        Assert.assertFalse(isIngresso02Add);
    }
}
