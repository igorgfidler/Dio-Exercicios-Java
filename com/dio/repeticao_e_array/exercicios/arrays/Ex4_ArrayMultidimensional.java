package com.dio.repeticao_e_array.exercicios.arrays;

import java.util.Arrays;
import java.util.Random;

public class Ex4_ArrayMultidimensional {
    public static void main(String[] args) {
        Random rng = new Random();
        int[][] matriz = new int[4][4];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rng.nextInt(100);
            }
        }

        Arrays.asList(matriz)
                .stream()
                .map(Arrays::toString)
                .forEach(x -> System.out.println(x));
    }

}
