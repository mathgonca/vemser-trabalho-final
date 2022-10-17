package com.br.dbc.app.service;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.model.Filme;
import com.br.dbc.app.model.Ingresso;
import com.br.dbc.app.model.IngressoComprado;
import com.br.dbc.app.repository.FilmeRepository;
import com.br.dbc.app.repository.IngressoRepository;

import java.sql.SQLException;
import java.util.List;

public class IngressoService {

    private IngressoRepository ingressoRepository;

    public IngressoService() {
        ingressoRepository = new IngressoRepository();
    }

    public void adicionarIngresso(Ingresso ingresso) {

        try {

            Ingresso addIngresso = ingressoRepository.adicionar(ingresso);

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());


        }
    }

    public void removerIngresso(Integer id) {
        try{
            boolean realizouRemover = ingressoRepository.remover(id);

        } catch(BancoDeDadosException e){
            e.printStackTrace();
        }

    }

    public void editaringresso(Integer id, Ingresso ingresso){
        try{
            boolean realizouEditar = ingressoRepository.editar(id, ingresso);

        } catch(BancoDeDadosException e){
            e.printStackTrace();
        }

    }

    public void listarIngresso(){
        try{
            List<Ingresso> list = ingressoRepository.listar();
            list.forEach(System.out::println);

        } catch(BancoDeDadosException e){
            e.printStackTrace();
        }

    }
    public void listarIngressoComprado(Integer id){
        try{
        List<IngressoComprado> list = ingressoRepository.listarIngressoComprado(id);
        list.forEach(System.out::println);
        } catch(BancoDeDadosException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
