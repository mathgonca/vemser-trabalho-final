package com.br.dbc.app.repository;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.model.Cliente;
import com.br.dbc.app.model.Filme;
import com.br.dbc.app.model.Ingresso;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository <CHAVE, OBJETO> {
    Integer getProximoId(Connection connection) throws SQLException;

    OBJETO adicionar(OBJETO object) throws BancoDeDadosException;

    Ingresso adicionar(Ingresso ingresso, Cliente cliente, Cinema cinema, Filme filme) throws BancoDeDadosException;

    boolean remover(CHAVE id) throws BancoDeDadosException;

    boolean editar(CHAVE id, OBJETO objeto) throws BancoDeDadosException;

    List<OBJETO> listar() throws BancoDeDadosException;
}