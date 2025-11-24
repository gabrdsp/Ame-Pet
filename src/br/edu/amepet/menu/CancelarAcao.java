package br.edu.amepet.menu;

import java.util.Scanner;

//adicionei funcao de cancelar a acao com !sair

public class CancelarAcao {

    public static String readLineAllowExit(Scanner sc) {
        String line = sc.nextLine();
        if (line == null) return null;
        if (line.equalsIgnoreCase("!sair")) return null;
        return line;
    }

    public static Integer readIntAllowExit(Scanner sc) {
        String line = readLineAllowExit(sc);
        if (line == null) return null;1
        
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double readDoubleAllowExit(Scanner sc) {
        String line = readLineAllowExit(sc);
        if (line == null) return null;
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
