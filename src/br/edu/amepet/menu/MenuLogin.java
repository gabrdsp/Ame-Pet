package br.edu.amepet.menu;

import br.edu.amepet.gerenciador.GerenciadorPetShop;
import br.edu.amepet.modelo.pessoa.Funcionario;

import java.util.Scanner;

public class MenuLogin {
    public static Funcionario exibirLogin(GerenciadorPetShop sistema, Scanner sc) {
        System.out.println("\n---- LOGIN de FUNCIONÁRIO ----");
        System.out.print("Usuário: ");
        String usuario = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();

        Funcionario funcionarioLogado = sistema.loginFuncionario(usuario, senha);

        if (funcionarioLogado != null) {
            System.out.println("Login Realizado com sucesso!\n");
        } else {
            System.out.println("Usuário ou senha incorretos!\n");
        }

        return funcionarioLogado;
    }
}
