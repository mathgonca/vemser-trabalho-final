package com.br.dbc.app.view.cliente;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.exceptions.ClienteNaoEncontradoException;
import com.br.dbc.app.exceptions.CpfInvalidoException;
import com.br.dbc.app.model.Cliente;
import com.br.dbc.app.model.Ingresso;
import com.br.dbc.app.repository.IngressoDTORepository;
import com.br.dbc.app.repository.IngressoRepository;
import com.br.dbc.app.service.CinemaService;
import com.br.dbc.app.service.ClienteService;
import com.br.dbc.app.service.FilmeService;
import com.br.dbc.app.service.IngressoService;

import java.sql.SQLException;
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

    public static void menuCliente() throws SQLException {
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
                                int idCinema = 0 ;
                                int idFilme = 0 ;

                                System.out.println(formatarTitulo("CINEMAS DISPONIVEIS"));

                                cinemaService.listarCinema();

                                System.out.println("");
                                System.out.println(formatarTitulo("*"));
                                System.out.println("           Digite o ID do cinema escolhido: ");
                                System.out.println(formatarTitulo("*"));
                                System.out.println("");

                                idCinema = scanner.nextInt();
                                scanner.nextLine();

                                ingresso.setIdCinema(idCinema);

                                System.out.println("");
                                System.out.println(formatarTitulo("        *       "));
                                System.out.println("                    * FILMES EM CARTAZ *                    ");
                                System.out.println(formatarTitulo("        *       "));
                                System.out.println("");

                                FilmeService filme = new FilmeService();
                                filme.listarFilmes();

                                System.out.println("");
                                System.out.println(formatarTitulo("*"));
                                System.out.println("     Agora, escolha a Id do filme que deseja assistir:");
                                System.out.println(formatarTitulo("*"));
                                System.out.println("");

                                idFilme= scanner.nextInt();
                                scanner.nextLine();
                                ingresso.setIdFilme(idFilme);

                                System.out.println("");
                                System.out.println(formatarTitulo("         *          "));
                                System.out.println("                    * BALCÃO  DE INGRESSOS *                    ");
                                System.out.println(formatarTitulo("         *          "));
                                System.out.println("");

                                IngressoService ingressoAcomprar = new IngressoService();
                                ingressoAcomprar.listarIngressoDTO(idFilme, idCinema);

                                System.out.println("");
                                System.out.println(formatarTitulo("*"));
                                System.out.println("            Agora selecione a opção de compra!");
                                System.out.println(formatarTitulo("*"));
                                System.out.println("");

                                int idIngresso = scanner.nextInt();
                                scanner.nextLine();
                                ingresso.setIdIngresso(idIngresso);
                                ingressoAcomprar.editaringresso(idIngresso, ingresso);

                                System.out.println("");
                                System.out.println(formatarTitulo("*"));
                                System.out.println("               Compra efetuada com sucesso!");
                                System.out.println(formatarTitulo("*"));
                                System.out.println("");


                                break;
                            case LISTAR_INGRESSOS:
                                System.out.println(formatarTitulo("LISTA DE INGRESSOS"));
                                int id = clienteLogado.getIdCliente();
                                IngressoService listarIngressoComprado = new IngressoService();
                                listarIngressoComprado.listarIngressoComprado(id);
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
