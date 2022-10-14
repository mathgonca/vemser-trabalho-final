package com.br.app;

import com.br.app.crud.impl.CinemaCrud;
import com.br.app.crud.impl.FilmeCrud;
import com.br.app.crud.impl.ImplClienteCrud;
import com.br.app.crud.impl.IngressoCrud;
import com.br.app.entidades.Cinema;
import com.br.app.entidades.Cliente;
import com.br.app.entidades.Filme;
import com.br.app.entidades.Ingresso;
import com.br.app.entidades.enums.Disponibilidade;
import com.br.app.entidades.enums.Idioma;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int CLIENTE = 1;
        final int CINEMA = 2;

        final int CADASTRAR_USUARIO = 1;
        final int SELECIONAR_CLIENTE = 2;

        Cinema cinema = new Cinema("GNC Praia de Belas", "Rio Grande do Sul", "Porto Alegre");

        CinemaCrud cinemaCrud = new CinemaCrud();
        cinemaCrud.adicionar(cinema);

        Filme filme01 = new Filme("Vingadores: Ultimato", Idioma.LEGENDADO, 12, 182, cinema);
        Filme filme02 = new Filme("Homem-Aranha: Sem Volta para Casa", Idioma.LEGENDADO, 12, 157, cinema);
        Filme filme03 = new Filme("Batman", Idioma.DUBLADO, 14, 176, cinema);

        FilmeCrud filmeCrud = new FilmeCrud();
        filmeCrud.adicionar(filme01);
        filmeCrud.adicionar(filme02);
        filmeCrud.adicionar(filme03);

        IngressoCrud ingressoCrud = new IngressoCrud();

        for (int i = 0; i < filmeCrud.listarTodos().size(); ++i) {
            Filme filme = filmeCrud.listarPeloId(i);

            for (int j = 0; j < 5; ++j) {
                Ingresso ingresso = new Ingresso(j, 30, LocalDateTime.now().plusDays(1), filme);
                ingressoCrud.adicionar(ingresso);
            }
        }

        Ingresso ingresso01 = new Ingresso(1, LocalDateTime.now(), filme01);
        Ingresso ingresso02 = new Ingresso(3, LocalDateTime.now(), filme02);
        Ingresso ingresso03 = new Ingresso(10, LocalDateTime.now(), filme03);

        ImplClienteCrud clienteCrud = new ImplClienteCrud();

        Cliente clienteLogado = new Cliente();
        clienteLogado.setCpf("12345678900");
        clienteCrud.adicionar(clienteLogado);

        clienteCrud.adicionarIngresso(clienteLogado, ingresso01);
        clienteCrud.adicionarIngresso(clienteLogado, ingresso02);
        clienteCrud.adicionarIngresso(clienteLogado, ingresso03);

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========Seja Bem Vindo ao CineDev=============");
        System.out.println("===================MENU=========================");
        System.out.println("1 - Se você for um cliente");
        System.out.println("2 - Se você for um cinema");
        System.out.print("Digite sua opção: ");

        int opcao1 = Integer.parseInt(scanner.nextLine());

        switch (opcao1) {
            case CLIENTE:
                System.out.println("===============CLIENTE======================");
                System.out.println("1 - Se deseja fazer o seu cadastro");
                System.out.println("2 - Selecionar o seu cadastro");
                System.out.print("Digite sua opção: ");
                int opcao2 = Integer.parseInt(scanner.nextLine());

                switch (opcao2) {
                    case CADASTRAR_USUARIO:
                        System.out.println("Cadastre seu usuário");
                        System.out.println("=".repeat(45));

                        System.out.print("Digite o seu nome: ");
                        String primeiroNome = scanner.nextLine();

                        System.out.print("Digite o seu segundo nome: ");
                        String segundoNome = scanner.nextLine();

                        System.out.print("Digite o seu CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Digite a sua idade: ");
                        int idade = Integer.parseInt(scanner.nextLine());

                        System.out.print("Digite o seu email: ");
                        String email = scanner.nextLine();

                        Cliente cliente = new Cliente(primeiroNome, segundoNome, cpf, idade, email);
                        clienteCrud.adicionar(cliente);
                        break;
                    case SELECIONAR_CLIENTE:
                        System.out.println("1 - Escolher um cinema");
                        System.out.println("2 - Listar ingressos comprados");
                        System.out.print("Digite sua opção: ");
                        int opcao3 = Integer.parseInt(scanner.nextLine());

                        switch (opcao3) {
                            case 1:
                                System.out.println("===============ESCOLHER CINEMA======================");
                                List<Cinema> cinemaList = cinemaCrud.listarTodos();
                                cinemaList.stream()
                                        .forEach(System.out::println);
                                System.out.println("=".repeat(45));
                                System.out.print("Digite o Id do cinema escolhido: ");
                                int cinemaId = Integer.parseInt(scanner.nextLine());

                                Cinema cinemaEscolhido = cinemaCrud.listarPeloId(cinemaId);

                                System.out.println("===============ESCOLHER CINEMA======================");
                                System.out.println(cinemaEscolhido);

                                System.out.println("===============ESCOLHER UM FILME======================");
                                filmeCrud.listarTodos().stream()
                                        .filter(filme -> cinemaEscolhido.equals(filme.getCinema()))
                                        .forEach(System.out::println);
                                System.out.println("=".repeat(45));
                                System.out.print("Digite o id do filme escolhido: ");
                                int filmeId = Integer.parseInt(scanner.nextLine());

                                Filme filme = filmeCrud.listarPeloId(filmeId);
                                List<Ingresso> ingressosDisponiveis = ingressoCrud.listarTodos().stream()
                                        .filter(ingresso -> filme.equals(ingresso.getFilme())
                                                && ingresso.getDisponibilidade() == Disponibilidade.DISPONIVEL)
                                        .toList();
                                ingressosDisponiveis.stream()
                                        .forEach(System.out::println);
                                System.out.println("=".repeat(45));
                                System.out.println("Digite o id do ingresso escolhido");
                                int ingressoId = Integer.parseInt(scanner.nextLine());

                                Ingresso ingresso = ingressoCrud.listarPeloId(ingressoId);
                                System.out.println("INGRESSO COMPRADO");
                                System.out.println(ingresso.getFilme());
                                System.out.println(ingresso);
                                clienteCrud.adicionarIngresso(clienteLogado, ingresso);
                                ingressoCrud.update(ingresso);
                                break;
                            case 2:
                                System.out.println("==============LISTAR INGRESSOS COMPRADOS======================");
                                List<Ingresso> ingressoList = clienteCrud.listaIngressosComprados(clienteLogado);
                                ingressoList.stream()
                                        .forEach(System.out::println);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                break;
            case CINEMA:
                System.out.println("===============CINEMA======================");
                System.out.println("1 - ");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        scanner.close();
    }
}