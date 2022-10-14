package com.br.app.crud.impl;

import com.br.app.entidades.Filme;
import com.br.app.entidades.enums.Idioma;
import org.junit.Assert;
import org.junit.Test;

public class FilmeCrudTest {

    @Test
    public void updateFilme() {
        Filme filme01 = new Filme("Vingadores: Ultimato", Idioma.LEGENDADO, 12, 182);
        Filme filme02 = new Filme("Homem-Aranha: Sem Volta para Casa", Idioma.LEGENDADO, 12, 157);
        Filme filme03 = new Filme("Batman", Idioma.DUBLADO, 14, 176);

        FilmeCrud crud = new FilmeCrud();
        crud.adicionar(filme01);
        crud.adicionar(filme02);
        crud.adicionar(filme03);

        Filme filmeUpdated = new Filme("Vingadores: Ultimato", Idioma.DUBLADO, 12, 182);

        crud.update(1, filmeUpdated);

        Assert.assertEquals(filmeUpdated, crud.valores.get(1));
    }
}
