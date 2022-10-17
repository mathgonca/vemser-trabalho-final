package com.br.dbc.app.view.cinema;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.exceptions.CinemaJaCadastradoException;
import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.service.CinemaService;

import java.util.Scanner;

import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class CinemaCadastroview {

    static CinemaService cinemaService = new CinemaService();

    private CinemaCadastroview() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuCinemaCadastro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(formatarTitulo("CINEMA"));
        System.out.println("Cadastrar um Cinema");

        System.out.println("Digite o nome do Cinema: ");
        String Nome = scanner.nextLine();

        System.out.println("Digite em Qual Estado o cinema se encontra: ");
        String Estado = scanner.nextLine();

        System.out.println("Digite a Cidade em que o cinema se encontra: ");
        String Cidade = scanner.nextLine();

        Cinema cinema = new Cinema(1, Nome, Estado, Cidade);

        try {
            cinemaService.adicionarCinema(cinema);
        } catch (BancoDeDadosException e) {
            throw new RuntimeException(e);
        } catch (CinemaJaCadastradoException e) {
            throw new RuntimeException(e);
        }
        cinemaService.listarCinema();
    }
}
