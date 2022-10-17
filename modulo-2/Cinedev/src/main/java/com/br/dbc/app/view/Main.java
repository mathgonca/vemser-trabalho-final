package com.br.dbc.app.view;

<<<<<<< HEAD
import com.br.dbc.app.exceptions.CpfInvalidoException;

=======
import com.br.dbc.app.exceptions.BancoDeDadosException;

import java.sql.SQLException;
>>>>>>> 465fd42d036e91ff6a683072758e4caa08a1e655
import java.util.Scanner;

import static com.br.dbc.app.view.cinema.CinemaView.menuCinema;
import static com.br.dbc.app.view.cliente.ClienteView.menuCliente;
import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) throws CpfInvalidoException {
=======
    public static void main(String[] args) throws SQLException {
>>>>>>> 465fd42d036e91ff6a683072758e4caa08a1e655
        final int CLIENTE = 1;
        final int CINEMA = 2;
        final int SAIR = 0;

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(formatarTitulo("CINEDEV"));
            System.out.println("1 - Cliente");
            System.out.println("2 - Cinema");
            System.out.println("0 - Para SAIR");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case CLIENTE:
                    menuCliente();
                    break;
                case CINEMA:
                    menuCinema();
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