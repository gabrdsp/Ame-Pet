package br.edu.amepet.menu;

import java.util.Scanner;

//Classe utilitária para leitura de entrada com suporte a cancelamento

public class CancelarAcao {

    // Constante para indicar cancelamento
    public static final String CANCELAMENTO = "*CANCELADO*";

    /**
     * Lê uma linha e verifica se o usuário quer cancelar (digitou *)
     * @param sc Scanner
     * @return CANCELAMENTO se o usuário digitou "*", caso contrário retorna o texto digitado
     */
    public static String readLine(Scanner sc) {
        String line = sc.nextLine();
        if (line.equals("*")) {
            return CANCELAMENTO;
        }
        return line;
    }

    /**
     * Lê um inteiro e verifica se o usuário quer cancelar (digitou *)
     * @param sc Scanner
     * @return CANCELAMENTO se o usuário digitou "*", null se não conseguir fazer parse, caso contrário retorna o inteiro parseado
     */
    public static String readInt(Scanner sc) {
        String line = sc.nextLine();
        if (line.equals("*")) {
            return CANCELAMENTO;
        }

        try {
            Integer.parseInt(line);
            return line; // Retorna a string para verificação posterior
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Lê um double e verifica se o usuário quer cancelar (digitou *)
     * @param sc Scanner
     * @return CANCELAMENTO se o usuário digitou "*", null se não conseguir fazer parse, caso contrário retorna o double parseado
     */
    public static String readDouble(Scanner sc) {
        String line = sc.nextLine();
        if (line.equals("*")) {
            return CANCELAMENTO;
        }
        try {
            Double.parseDouble(line);
            return line; // Retorna a string para verificação posterior
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Verifica se um valor representa cancelamento
     * @param valor String a verificar
     * @return true se for CANCELAMENTO, false caso contrário
     */
    public static boolean isCancelado(String valor) {
        return valor != null && valor.equals(CANCELAMENTO);
    }
}
