package com.br.dbc.app.view.cinema;

import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.service.CinemaService;

import java.util.Scanner;

import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class CinemaCadastroview {

    private CinemaCadastroview() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuCinemacadastro() {
        final int ADICIONAR = 1;
        final int REMOVER = 2;
        final int EDITAR = 3;
        final int LISTAR = 4;
        final int SAIR = 0;

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(formatarTitulo("CINEMA"));
            System.out.println("1 - Adicionar um Cinema");
            System.out.println("2 - Remover um Cinema");
            System.out.println("3 - Editar um Cinema");
            System.out.println("4 - Listar um Cinema");
            System.out.println("0 - Para SAIR");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case ADICIONAR:
                    Cinema cinema = new Cinema();
                    System.out.println("Digite o nome do Cinema: ");
                    cinema.setNome(scanner.nextLine());

                    System.out.println("Digite em Qual Estado o cinema se encontra: ");
                    String text = scanner.nextLine();
                    cinema.setEstado(scanner.nextLine());

                    System.out.println("Digite a Cidade em que o cinema se encontra: ");
                    cinema.setCidade(scanner.nextLine());

                    CinemaService.adicionarCinema(cinema);
                    break;

                case REMOVER:
                    System.out.println("Qual Cinema você deseja Remover?");
                    CinemaService.listarCinema();
                    int id = scanner.nextInt();
                    CinemaService.removerCinema(id);
                    break;

                case EDITAR:
                    System.out.println("Qual Cinema você deseja editar?");
                    CinemaService.listarCinema();
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    Cinema cinemaNovo = new Cinema();
                    System.out.println("Digite o nome do Cinema");
                    cinemaNovo.setNome(scanner.nextLine());

                    System.out.println("Digite em Qual Estado o cinema se encontra: ");
                    cinemaNovo.setEstado(scanner.nextLine());

                    System.out.println("Digite a Cidade em que o cinema se encontra: ");
                    cinemaNovo.setCidade(scanner.nextLine());

                    CinemaService.editarCinema(index, cinemaNovo);
                    break;

                case LISTAR:
                    CinemaService.listarCinema();
                    break;

                default:
                    System.err.println("Opção inválida!");
                    break;
            }
        }
    }
}