package com.dio.repeticao_e_array.exercicios.repeticao;

import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Ex6_Fatorial {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Insira um número para mostrar o fatorial: ");
            while (!s.hasNextInt()) {
                System.out.println("Por favor insira um número");
                s.next();
            }
            int numero = s.nextInt();
            System.out.println("Fatorial iterativo de " + numero + " = " + fatorialNormal(numero));
            System.out.println("Fatorial recursivo de " + numero + " = " + fatorialRecursivo(numero));

        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static int fatorialNormal(int numero) {
        OptionalInt resposta = IntStream
                .rangeClosed(1, numero)
                .reduce((x, y) -> x * y);

        if (resposta.isEmpty()) {
            return 1;
        } else {
            return resposta.getAsInt();
        }
    }

    private static int fatorialRecursivo(int numero) {
        if (numero <= 0) {
            return 1;
        }
        return fatorialRecursivo(numero - 1) * numero;
    }
}
