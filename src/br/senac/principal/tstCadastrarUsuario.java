package br.senac.principal;

import br.senac.model.Usuario;

import java.util.Scanner;

public class tstCadastrarUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner dados = new Scanner(System.in);
        int opcao;

        System.out.println("DIGITE UM NUMERO:");
        System.out.println("1 - CADASTRAR");
        System.out.println("2 - ATUALIZAR");
        System.out.println("3 - DELETAR");
        System.out.println("4 - LISTAR TODOS");
        System.out.println("5 - Sair");

        opcao = scanner.nextInt();
         if(opcao == 1){
             System.out.println("Informe o login:" );
             String login = dados.next();
             System.out.println("Informe a senha:");
             String senha = dados.next();
             System.out.println("Informe o cargo:");
             String cargo = dados.next();
             System.out.println("Informe o nivel de acesso:");
             int nivel_acesso = dados.nextInt();
         }
        Usuario usuario = new Usuario();
    }
}