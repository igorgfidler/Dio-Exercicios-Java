package com.dio.repeticao_e_array.exercicios.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_Consoantes {
    public static void main(String[] args) {
        String[] consoantes = new String[6];
        int counter = 0;
        int quantiaConsoantes = 0;
        try (Scanner s = new Scanner(System.in)) {
            do {
                String letra = s.next();
                if (!isVogal(letra)) {
                    consoantes[quantiaConsoantes] = letra;
                    quantiaConsoantes++;
                }
                counter++;
            } while (counter < consoantes.length);

        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.print("As consoantes inseridas foram: ");
        Arrays.asList(consoantes).stream().filter(x -> x != null).forEach(x -> System.out.print(x + " "));
    }

    private static boolean isVogal(String letra) {
        boolean isA = letra.equalsIgnoreCase("a");
        boolean isE = letra.equalsIgnoreCase("e");
        boolean isI = letra.equalsIgnoreCase("i");
        boolean isO = letra.equalsIgnoreCase("o");
        boolean isU = letra.equalsIgnoreCase("u");
        return isA || isE || isI || isO || isU;
    }
}
