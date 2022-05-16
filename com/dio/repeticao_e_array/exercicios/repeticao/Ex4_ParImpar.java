package com.dio.repeticao_e_array.exercicios.repeticao;

import java.util.Scanner;

public class Ex4_ParImpar {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            while (s.hasNextInt()) {
                int numero = s.nextInt();
                if (numero < 0) {
                    System.out.println("O número deve ser maior ou igual a 0");
                    continue;
                }
                if (isPar(numero)) {
                    System.out.println("O número " + numero + " é par.");
                } else {
                    System.out.println("O número " + numero + " é impar.");
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static boolean isPar(int numero) {
        return numero % 2 == 0;
    }
}
