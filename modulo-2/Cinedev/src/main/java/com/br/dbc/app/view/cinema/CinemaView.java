package com.br.dbc.app.view.cinema;

import java.util.Scanner;

import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class CinemaView {

    private CinemaView() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuCinema() {
        final int ADICIONAR = 1;
        final int REMOVER = 2;
        final int SAIR = 0;

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(formatarTitulo("CINEMA"));
            System.out.println("1 - Adicionar filme");
            System.out.println("2 - Remover filme");
            System.out.println("0 - Para SAIR");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case ADICIONAR:
                    System.out.println(formatarTitulo("Adicionar um novo filme"));
                    break;
                case REMOVER:
                    System.out.println(formatarTitulo("Remover um filme"));
                    break;
                case SAIR:
                    break;
                default:
                    System.err.println("Opção inválida!");
                    break;
            }
        }
    }
}