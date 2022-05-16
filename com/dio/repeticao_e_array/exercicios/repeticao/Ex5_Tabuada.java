package com.dio.repeticao_e_array.exercicios.repeticao;

import java.util.Scanner;

public class Ex5_Tabuada {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Insira um número para monstrar a tabuada: ");
            while (!s.hasNextInt()) {
                System.out.println("Por favor insira um número");
                s.next();
            }

            // s.nextInt is valid in here
            int numero = s.nextInt();
            String tabuada = gerarTabuada(numero);
            System.out.println(tabuada);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String gerarTabuada(int numero) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= 10; ++i) {
            String str = String.format("%d * %d = %d\n", numero, i, numero * i);
            s.append(str);
        }
        return new String(s);

    }

}
