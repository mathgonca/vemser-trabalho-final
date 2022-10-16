package com.br.dbc.app.service;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.repository.CinemaRepository;

import java.util.List;

public class CinemaService {


    private CinemaRepository cinemaRepository;

    public CinemaService() {
        cinemaRepository = new CinemaRepository();
    }

    public void adicionarCinema(Cinema cinema) {

        try {

            Cinema addCinema = cinemaRepository.adicionar(cinema);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());


        }
    }

    public void removerCinema(Integer id) {
        try {
            boolean realizouRemover = cinemaRepository.remover(id);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }

    }

    public void editarCinema(Integer id, Cinema cinema) {
        try {
            boolean realizouEditar = cinemaRepository.editar(id, cinema);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }

    }

    public void listarCinema() {
        try {
            List<Cinema> list = cinemaRepository.listar();
            list.forEach(System.out::println);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }

    }
}
