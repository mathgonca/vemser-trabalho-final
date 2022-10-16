package com.br.dbc.app.view.cliente;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.exceptions.ClienteNaoEncontradoException;
import com.br.dbc.app.exceptions.CpfInvalidoException;
import com.br.dbc.app.model.Cinema;
import com.br.dbc.app.model.Cliente;
import com.br.dbc.app.model.Filme;
import com.br.dbc.app.model.Ingresso;
import com.br.dbc.app.model.enums.Disponibilidade;
import com.br.dbc.app.service.CinemaService;
import com.br.dbc.app.service.ClienteService;
import com.br.dbc.app.service.FilmeService;
import com.br.dbc.app.service.IngressoService;

import java.sql.Timestamp;
import java.util.Scanner;

import static com.br.dbc.app.view.cliente.ClienteCadastroView.menuClienteCadastro;
import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class ClienteViewNoahMudouOlharPraVerSeÉIsso {static ClienteService clienteService = new ClienteService();


    //ATENÇÃO: FIZ ALTERAÇÕES NESSA CLASSE, MAS COMO NÃO TINHA CERTEZA SE ERA ESSA A IDEIA
 //   MANTIVE AS ORIGINAL!


    public ClienteViewNoahMudouOlharPraVerSeÉIsso() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuCliente() {
        final int CADASTRAR_CLIENTE = 1;
        final int LOGAR = 2;
        final int SAIR = 0;

        Cliente clienteLogado = null;

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
                    menuClienteCadastro();
                    break;
                case LOGAR:
                    System.out.println(formatarTitulo("Login"));

                    System.out.print("Digite o seu CPF: ");
                    try {
                        String cpf = scanner.nextLine();
                        clienteLogado = clienteService.logarCliente(cpf);
                    } catch (CpfInvalidoException | BancoDeDadosException | ClienteNaoEncontradoException e) {
                        throw new RuntimeException(e);
                    }

                    while (clienteLogado != null) {
                        final int ESCOLHER_CINEMA = 1;
                        final int LISTAR_INGRESSOS = 2;

                        System.out.println(formatarTitulo("CLIENTE LOGADO"));
                        System.out.println("Clinte logado: " + clienteLogado.getPrimeiroNome() + " " + clienteLogado.getUltimoNome());
                        System.out.println("1 - Escolher um cinema");
                        System.out.println("2 - Listar ingressos comprados");
                        System.out.println("0 - Para SAIR");

                        int opcao3 = Integer.parseInt(scanner.nextLine());

                        switch (opcao3) {
                            case ESCOLHER_CINEMA:
                                Ingresso ingresso = new Ingresso();
                                Cinema cinemaEscolhido = new Cinema();
                                Filme filmeEscolhido = new Filme();

                                System.out.println(formatarTitulo("CINEMAS DISPONIVEIS"));

                                CinemaService cinemaService = new CinemaService();
                                cinemaService.listarCinema();

                                System.out.print("Digite o ID do cinema escolhido: ");
                                int teclado = scanner.nextInt();
                                scanner.nextLine();

                                cinemaEscolhido.setIdCinema(teclado);
                                ingresso.setCinema(cinemaEscolhido);

                                FilmeService filme = new FilmeService();
                                filme.listarFilmes();

                                System.out.println("Agora, escolha a Id do filme que deseja assistir:");
                                int teclado1 = scanner.nextInt();
                                scanner.nextLine();

                                filmeEscolhido.setIdFilme(teclado1);
                                ingresso.setFilme(filmeEscolhido);

                                System.out.println("Insira o numero de uma das poltronas livres apresentadas a seguir:");
                                System.out.println("Poltrona - 10");
                                System.out.println("Poltrona - 11");
                                System.out.println("Poltrona - 12");

                                int teclado4 = scanner.nextInt();
                                scanner.nextLine();

                                ingresso.setCadeira(teclado4);

                                System.out.println("Escolha a data e o horario que deseja assistir:");
                                System.out.println("1 - 20/10/2022 as 21:30");
                                System.out.println("2 - 20/10/2022 as 21:30");
                                System.out.println("3 - 20/10/2022 as 21:30");
                                //ADICIONAR MANIPULAÇÃO DE DATAS E DAR ingresso.setDataHora();

                                System.out.println("O Valor do ingresso é:");
                                System.out.println("1 - 14,30 - Basta inserir essa opção para efetuar a compra!");
                                System.out.println("2 - Digite essa opção caso possua algum desconto");
                                int teclado2 = scanner.nextInt();
                                scanner.nextLine();

                                ingresso.setPreco(14.30);
                                ingresso.setDataHora(Timestamp.valueOf("2022-09-22 21:30:00"));
                                ingresso.setDisponibilidade(Disponibilidade.S);
                                IngressoService ingressoService =  new IngressoService();
                                ingressoService.adicionarIngresso(ingresso);
                                ingressoService.listarIngresso();


                                break;
                            case LISTAR_INGRESSOS:
                                System.out.println(formatarTitulo("LISTA DE INGRESSOS"));

                                break;
                            case SAIR:
                                clienteLogado = null;
                                break;
                            default:
                                System.err.println("Opção inválida!");
                                break;
                        }
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


