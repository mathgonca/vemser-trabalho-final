package com.br.dbc.app.view.cliente;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.exceptions.ClienteNaoEncontradoException;
import com.br.dbc.app.exceptions.CpfInvalidoException;
import com.br.dbc.app.model.Cliente;
import com.br.dbc.app.service.CinemaService;
import com.br.dbc.app.service.ClienteService;
import com.br.dbc.app.service.FilmeService;

import java.util.Scanner;

import static com.br.dbc.app.view.cliente.ClienteCadastroView.menuClienteCadastro;
import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class ClienteView {

    static ClienteService clienteService = new ClienteService();
    static CinemaService cinemaService = new CinemaService();
    static FilmeService filmeService = new FilmeService();

    private ClienteView() {
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
                                int idCinemaEscolhido;
                                int idFilmeEscolhido;

                                System.out.println(formatarTitulo("CINEMAS DISPONIVEIS"));
                                // LISTAR CINEMAS DISPONIVEIS
                                cinemaService.listarCinema();
                                System.out.print("Digite o ID do cinema escolhido: ");
                                idCinemaEscolhido = Integer.parseInt(scanner.nextLine());

                                filmeService.listarFilmes();

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
