package com.br.dbc.app.service;

import com.br.dbc.app.exceptions.BancoDeDadosException;
import com.br.dbc.app.exceptions.ClienteJaCadastradoException;
import com.br.dbc.app.exceptions.ClienteNaoEncontradoException;
import com.br.dbc.app.exceptions.CpfInvalidoException;
import com.br.dbc.app.model.Cliente;
import com.br.dbc.app.repository.ClienteRepository;

import java.util.Optional;

public class ClienteService {

    private ClienteRepository repository;

    public ClienteService() {
        repository = new ClienteRepository();
    }

    public void cadastrarCliente(Cliente cliente) throws BancoDeDadosException, ClienteJaCadastradoException, CpfInvalidoException {
        if (cliente.getCpf().length() != 11) {
            throw new CpfInvalidoException("CPF Inválido!");
        }

        String clienteCadastroCPF = cliente.getCpf();
        String clienteCadastroEmail = cliente.getEmail();

        Optional<Cliente> clientePorCPF = repository.listarClientePorCPF(clienteCadastroCPF);
        Optional<Cliente> clientePorEmail = repository.listarClientePorEmail(clienteCadastroEmail);

        if (clientePorCPF.isEmpty() && clientePorEmail.isEmpty()) {
            repository.adicionar(cliente);
        } else {
            throw new ClienteJaCadastradoException("Já existe um cliente cadastrado com esse CPF!");
        }
    }

    public Cliente logarCliente(String cpf) throws CpfInvalidoException, BancoDeDadosException, ClienteNaoEncontradoException {
        if (cpf.length() != 11) {
            throw new CpfInvalidoException("CPF Inválido!");
        }

        Optional<Cliente> clientePorCPF = repository.listarClientePorCPF(cpf);
        if (clientePorCPF.isPresent()) {
            return clientePorCPF.get();
        } else {
            throw new ClienteNaoEncontradoException("Cliente não encontrado!");
        }
    }
}
