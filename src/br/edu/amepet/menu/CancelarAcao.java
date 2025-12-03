package br.edu.amepet.menu;

import java.util.Scanner;

//Classe utilitária para leitura de entrada com suporte a cancelamento
public class CancelarAcao {
    // Lê uma string obrigatória (não pode ser número), repete até entrada válida ou cancelamento
     
    public static String readStringSafe(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line.equals("*")) return CANCELAMENTO;
            if (line.trim().isEmpty()) {
                System.out.println("Informação incorreta, digite novamente.");
                continue;
            }
            if (line.matches("\\d+")) {
                System.out.println("Informação incorreta, digite novamente.");
                continue;
            }
            return line;
        }
    }

    
    // Lê uma string com rótulo que é reexibido a cada tentativa inválida
    public static String readStringSafe(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String line = sc.nextLine();
            if (line.equals("*")) return CANCELAMENTO;
            if (line.trim().isEmpty() || line.matches("\\d+")) {
                System.out.println("Informação incorreta, digite novamente.");
                continue;
            }
            return line;
        }
    }

    //Lê um inteiro, repete até entrada válida ou cancelamento
     
    public static Integer readIntSafe(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line.equals("*")) return null;
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Informação incorreta, digite novamente.");
            }
        }
    }

    
    // Lê um inteiro com rótulo que é reexibido a cada tentativa inválida
    public static Integer readIntSafe(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String line = sc.nextLine();
            if (line.equals("*")) return null;
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Informação incorreta, digite novamente.");
            }
        }
    }

    // Lê um double, repete até entrada válida ou cancelamento
    public static Double readDoubleSafe(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line.equals("*")) return null;
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Informação incorreta, digite novamente.");
            }
        }
    }

    // Lê um double com rótulo que é reexibido a cada tentativa inválida
    public static Double readDoubleSafe(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String line = sc.nextLine();
            if (line.equals("*")) return null;
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Informação incorreta, digite novamente.");
            }
        }
    }

// Lê apenas dígitos (como CPF, quantidade), repete até válido ou cancelamento
    
    public static String readDigitsSafe(Scanner sc) {
        while (true) {
            String line = sc.nextLine();
            if (line.equals("*")) return CANCELAMENTO;
            if (line.matches("\\d+")) return line;
            System.out.println("Informação incorreta, digite novamente.");
        }
    }

    //Lê apenas dígitos com rótulo que é reexibido a cada tentativa inválida
    
    public static String readDigitsSafe(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String line = sc.nextLine();
            if (line.equals("*")) return CANCELAMENTO;
            if (line.matches("\\d+")) return line;
            System.out.println("Informação incorreta, digite novamente.");
        }
    }

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

    //Lê qualquer entrada com rótulo que é reexibido a cada tentativa vaziaÚtil para senhas, usuários e campos que aceitam qualquer formato
    public static String readLineSafe(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String line = sc.nextLine();
            if (line.equals("*")) return CANCELAMENTO;
            if (!line.trim().isEmpty()) {
                return line;
            }
            System.out.println("Informação incorreta, digite novamente.");
        }
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
            return line; 
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
            return line; 
        } catch (NumberFormatException e) {
            return null;
        }
    }

    //Verifica se um valor representa cancelamento
     
    public static boolean isCancelado(String valor) {
        return valor != null && valor.equals(CANCELAMENTO);
    }
}
