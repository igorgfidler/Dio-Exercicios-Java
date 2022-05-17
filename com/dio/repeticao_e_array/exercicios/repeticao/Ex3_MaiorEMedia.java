package com.dio.repeticao_e_array.exercicios.repeticao;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;

public class Ex3_MaiorEMedia {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println("Insira os valores");
        try (Scanner s = new Scanner(System.in)) {
            while (s.hasNextInt()) {
                list.add(s.nextInt());
            }
        } // no need to check NoSuchElement neither InputMismatch exceptions
          // hasNextInt garantes this wont happen.
        catch (IllegalStateException e) {
            e.printStackTrace();
            System.exit(1);
        }

        OptionalInt maiorValor = list.stream()
                .mapToInt(x -> x) // this mapping is just for convinience, just to get max method
                .max(); // rather than using a reduce operation
        /*
         * equivalent to
         * Optional<Integer> maiorvalor = list.stream().reduce(Integer::max);
         */

        // same goes here
        OptionalDouble media = list.stream().mapToInt(x -> x).average();

        System.out.println(
                "O maior valor é: " + (maiorValor.isPresent() ? maiorValor.getAsInt() : "nenhum valor foi inserido"));
        System.out.println(
                "A média dos valores é: " + (media.isPresent() ? media.getAsDouble() : "nenhum valor foi inserido"));
        // This works too
        System.out.println(list.stream().mapToInt(x -> x).summaryStatistics());
    }
}