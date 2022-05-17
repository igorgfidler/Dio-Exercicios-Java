package com.dio.repeticao_e_array.exercicios.arrays;

import java.util.Arrays;

public class Ex1_OrdemInversa {
    public static void main(String[] args) {
        int[] list = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(list));
        System.out.print("Lista em ordem reversa: ");
        for (int i = list.length - 1; i >= 0; i--) {
            System.out.print(list[i]);
        }
    }

}
