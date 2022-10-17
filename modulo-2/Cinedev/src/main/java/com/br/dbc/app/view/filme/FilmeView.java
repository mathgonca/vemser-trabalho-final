package com.br.dbc.app.view.filme;

import com.br.dbc.app.service.FilmeService;

import java.util.Scanner;

import static com.br.dbc.app.view.filme.FilmeCadastroView.menuFilmeCadastro;
import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class FilmeView {

    private FilmeView() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuFilme() {
        final int ADICIONAR = 1;
        final int REMOVER = 2;
        final int SAIR = 0;

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(formatarTitulo("FILME"));
            System.out.println("1 - Cadastrar filme");
            System.out.println("2 - Remover filme");
            System.out.println("0 - Para SAIR");

            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case ADICIONAR:
                    System.out.println(formatarTitulo("Adicionar um novo filme"));
                    menuFilmeCadastro();
                    break;
                case REMOVER:
                    System.out.println(formatarTitulo("Remover um filme"));

                    FilmeService removerListar = new FilmeService();
                    removerListar.listarFilmes();

                    System.out.println("Insira a Id do filme que deseja remover: ");

                    int tec = scanner.nextInt();
                    scanner.nextLine();

                    removerListar.removerFilme(tec);

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
