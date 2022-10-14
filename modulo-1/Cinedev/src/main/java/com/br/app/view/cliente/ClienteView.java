package com.br.app.view.cliente;

import java.util.Scanner;

import static com.br.app.view.FormatarTitulo.formatarTitulo;

public class ClienteView {

    private ClienteView() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuCliente() {
        final int CADASTRAR_CLIENTE = 1;
        final int LOGAR = 2;
        final int SAIR = 0;

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(formatarTitulo("CLIENTE"));
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("0 - Para SAIR");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case CADASTRAR_CLIENTE:
                    System.out.println(formatarTitulo("Cadastrar cliente"));
                    break;
                case LOGAR:
                    final int ESCOLHER_CINEMA = 1;
                    final int LISTAR_INGRESSOS = 2;

                    System.out.println(formatarTitulo("CLIENTE LOGADO"));
                    System.out.println("1 - Escolher um cinema");
                    System.out.println("2 - Listar ingressos comprados");
                    System.out.println("0 - Para SAIR");

                    int opcao3 = Integer.parseInt(scanner.nextLine());
                    switch (opcao3) {
                        case ESCOLHER_CINEMA:
                            System.out.println(formatarTitulo("CINEMAS DISPONIVEIS"));
                            // LISTAR CINEMAS DISPONIVEIS
                            System.out.print("Digite o ID do cinema escolhido: ");
                            break;
                        case LISTAR_INGRESSOS:
                            System.out.println(formatarTitulo("LISTA DE INGRESSOS"));
                            break;
                        case SAIR:
                            break;
                        default:
                            System.err.println("Opção inválida!");
                            break;
                    }
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
