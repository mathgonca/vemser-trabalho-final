package com.br.dbc.app.view.filme;

import com.br.dbc.app.model.Filme;
import com.br.dbc.app.model.enums.Idioma;
import com.br.dbc.app.service.FilmeService;

import java.util.Scanner;

import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class FilmeCadastroView {
    static FilmeService filmeService = new FilmeService();

    private FilmeCadastroView() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuFilmeCadastro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(formatarTitulo("Cadastrar filme"));
        System.out.print("Digte o Titulo do Filme: ");
        String nomeFilme = scanner.nextLine();

        System.out.print("Insira opção de idioma: Legendado ou Dublado? ");
        Idioma idioma = Idioma.valueOf(scanner.nextLine());

        System.out.print("Insira a Classificação Etaria do Filme: ");
        int classificacao = scanner.nextInt();

        System.out.println("Insira a duração do filme em MINUTOS:");
        int duracao = scanner.nextInt();

        Filme filme = new Filme(1,nomeFilme,idioma,classificacao,duracao);

        filmeService.adicionarFilme(filme);
        filmeService.listarFilmes();

    }
}
