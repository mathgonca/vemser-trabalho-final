package com.br.dbc.app.service;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Filme;
import com.br.dbc.app.repository.FilmeRepository;

import java.util.List;

public class FilmeService {

    private FilmeRepository filmeRepository;

    public FilmeService() {
        filmeRepository = new FilmeRepository();
    }

    public void adicionarFilme(Filme filme) {

        try {

            Filme addFilme = filmeRepository.adicionar(filme);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());


        }
    }

    public void removerFilme(Integer id) {
        try{
            boolean realizouRemover = filmeRepository.remover(id);

        } catch(BancoDeDadosException e){
            e.printStackTrace();
        }

    }

    public void editarFilme(Integer id, Filme filme){
        try{
            boolean realizouEditar = filmeRepository.editar(id, filme);

        } catch(BancoDeDadosException e){
            e.printStackTrace();
        }

    }

    public void listarFilmes(){
        try{
            List <Filme> list = filmeRepository.listar();
            list.forEach(System.out::println);

        } catch(BancoDeDadosException e){
            e.printStackTrace();
        }

    }
}
