package com.br.dbc.app.view.cliente;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.exceptions.ClienteJaCadastradoException;
import com.br.dbc.app.exceptions.CpfInvalidoException;
import com.br.dbc.app.model.Cliente;
import com.br.dbc.app.service.ClienteService;

import java.time.LocalDate;
import java.util.Scanner;

import static com.br.dbc.app.view.util.FormatarTitulo.formatarTitulo;

public class ClienteCadastroView {

    static ClienteService clienteService = new ClienteService();

    private ClienteCadastroView() {
        throw new IllegalStateException("Classe útil");
    }

    public static void menuClienteCadastro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(formatarTitulo("Cadastrar cliente"));
        System.out.print("Digte o seu primeiro nome: ");
        String primeiroNome = scanner.nextLine();

        System.out.print("Digite o seu último nome: ");
        String ultimoNome = scanner.nextLine();

        System.out.print("Digite o seu CPF: ");
        String cpfCadastro = scanner.nextLine();

        System.out.println("Digite sua data de nascimento: ");
        System.out.print("Digite o dia: ");
        int dia = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o número do mês: ");
        int mes = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o ano (yyyy): ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);

        Cliente cliente = new Cliente(primeiroNome, ultimoNome, cpfCadastro, dataNascimento, email);

        try {
            clienteService.cadastrarCliente(cliente);
        } catch (BancoDeDadosException | ClienteJaCadastradoException | CpfInvalidoException e) {
            throw new RuntimeException(e);
        }
    }
}
