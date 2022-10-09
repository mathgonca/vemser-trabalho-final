package com.br.app;

import com.br.app.crud.impl.ImplClienteCrud;
import com.br.app.entidades.Cliente;
import com.br.app.entidades.Filme;
import com.br.app.entidades.Ingresso;

import java.util.Scanner;

import static com.br.app.entidades.enums.Idioma.DUBLADO;
import static com.br.app.entidades.enums.Idioma.LEGENDADO;
import static java.lang.System.in;
import static java.lang.System.out;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);


        Filme filme1 = new Filme("Top Gun: Maverick", DUBLADO, 12, 131);
        Filme filme2 = new Filme("Thor: Amor e Trovão", DUBLADO, 14, 119);
        Filme filme3 = new Filme("Venom: Tempo de Carnificina", LEGENDADO, 14, 105);
        Filme filme4 = new Filme("Até o Último Homem", LEGENDADO, 16, 139);



        out.println("==========Seja Bem Vindo ao CineDev=============");
        out.println("===================MENU=========================");
        out.println("1 -Se deseja ver os Filmes em Cartaz ");
        out.println("2- Se deseja realizar um cadastro ");
        out.println("3- Se deseja comprar Comprar Ingressos ");
        out.println("4- Para sair");

       int opcao = scanner.nextInt();
       scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("filmes" + "\n" + filme1+ "\n" +filme2+ "\n" + filme3+ "\n" + filme4);
            break;
            case 2:
                Cliente cliente = new Cliente();
                System.out.println("Digite seu Primeiro Nome ");
                cliente.setPrimeiroNome(scanner.nextLine());
                out.println("Digite seu Sobrenome ");
                cliente.setUltimoNome(scanner.nextLine());
                out.println("Digite seu Cpf: ");
                cliente.setCpf(scanner.nextLine());
                out.println("Digite sua idade: ");
                cliente.setIdade(scanner.nextInt());
                out.println("Digite seu E-mail: ");
                cliente.setEmail(scanner.nextLine());

                Cliente
                break;
            case 3:
                Ingresso ingresso = new Ingresso();
                out.println("Digite a cadeira que deseja selecionar ");
                ingresso.setCadeira(scanner.nextInt());
                break;
            case 4:
                break;
            }
        }


    }



//        Filme filme1 = new Filme("piratas",DUBLADO,16,120);
//        Filme filme2 = new Filme("piratas 2" ,DUBLADO,16,120);
//
////       public Filme(String nome, Idioma idioma, int classificacaoEtaria, int duracao)
//
//
//
//
//        System.out.println("FILMES DISPONIVEIS\n"+filme1+"\n"+filme2);
//






