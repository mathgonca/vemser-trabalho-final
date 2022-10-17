package com.br.dbc.app.view.cinema;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.exceptions.CinemaNaoEncontradoException;
import com.br.dbc.app.exceptions.CpfInvalidoException;
import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.service.CinemaService;
import com.br.dbc.app.service.FilmeService;

import java.util.Scanner;

import static com.br.dbc.app.view.cinema.CinemaCadastroview.cinemaService;
import static com.br.dbc.app.view.cinema.CinemaCadastroview.menuCinemaCadastro;
import static com.br.dbc.app.view.filme.FilmeCadastroView.menuFilmeCadastro;
import static com.br.dbc.app.view.filme.FilmeView.menuFilme;
import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class CinemaView {

    private static CinemaService service;

    private CinemaView() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuCinema() throws CpfInvalidoException {
        final int CADASTRAR = 1;
        final int LOGAR = 2;
        final int SAIR = 0;

        Cinema cinemaLogado = null;

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(formatarTitulo("CINEMA"));
            System.out.println("1 - Cadastrar um Cinema");
            System.out.println("2 - Login ");
            System.out.println("0 - Para SAIR");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case CADASTRAR:
                    menuCinemaCadastro();
                    break;

                case LOGAR:
                    System.out.println(formatarTitulo("Login"));
                    System.out.println("\nInforme o ID do Cinema");
                    try {
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cinemaLogado = cinemaService.logarCinema(id);
                    } catch (BancoDeDadosException | CinemaNaoEncontradoException e) {
                        throw new RuntimeException(e);
                    }

                    while (cinemaLogado != null) {

                        final int CADASTRAR_FILME = 1;
                        final int REMOVER_FILME = 2;


                        int opcao3 = -1;
                        while (opcao3 != 0) {
                        System.out.println(formatarTitulo("CINEMA LOGADO"));
                        System.out.println("1- cadastrar um filme");
                        System.out.println("2- remover um filme");
                        System.out.println("0 - SAIR");

                        opcao3 = Integer.parseInt(scanner.nextLine());
                        switch (opcao3) {
                            case CADASTRAR_FILME:
                                menuFilmeCadastro();
                                break;
                            case REMOVER_FILME:
                                System.out.println(formatarTitulo("Remover um filme"));

                                FilmeService removerListar = new FilmeService();
                                removerListar.listarFilmes();

                                System.out.println("Insira a Id do filme que deseja remover: ");

                                int tec = scanner.nextInt();
                                scanner.nextLine();

                                removerListar.removerFilme(tec);

                                break;

                            case SAIR:
                                cinemaLogado = null;
                                break;

                                default:
                                System.err.println("Opção inválida!");
                                break;
                        }
                        }
                    }
            }
        }
    }
}

