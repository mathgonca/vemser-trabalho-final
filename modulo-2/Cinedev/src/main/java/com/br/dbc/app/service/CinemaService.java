package com.br.dbc.app.service;

import com.br.dbc.app.exceptions.*;
import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.repository.CinemaRepository;

import java.util.List;
import java.util.Optional;

public class CinemaService {
    private CinemaRepository cinemaRepository;

    public CinemaService() {
        cinemaRepository = new CinemaRepository();
    }

    public void listarCinema() {
        try {
            List<Cinema> list = cinemaRepository.listar();
            list.forEach(System.out::println);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }

    }

    public void adicionarCinema(Cinema cinema) throws BancoDeDadosException, CinemaJaCadastradoException {

//        int cinemaCadastroId = cinema.getIdCinema();
//
//        Optional<Cinema> listarCinemaId = cinemaRepository.listarCinemaId(cinemaCadastroId);
//
//        if (listarCinemaId.isEmpty()) {
//            cinemaRepository.adicionar(cinema);
//        } else {
//            throw new CinemaJaCadastradoException("Já existe um cliente cadastrado com esse CPF!");
//        }
        cinemaRepository.adicionar(cinema);
    }

    public void removerCinema(Integer id) {
        try {
            boolean realizouRemover = cinemaRepository.remover(id);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }

    }

    public Cinema logarCinema(int id) throws CpfInvalidoException, BancoDeDadosException, CinemaNaoEncontradoException {

        Optional<Cinema> listarCinemaId = cinemaRepository.listarCinemaId(id);
        if (listarCinemaId.isEmpty()) {
            return null;
        }
        return listarCinemaId.get();
    }
}

