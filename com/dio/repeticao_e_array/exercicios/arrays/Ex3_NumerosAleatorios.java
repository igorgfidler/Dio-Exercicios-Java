package com.dio.repeticao_e_array.exercicios.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex3_NumerosAleatorios {
    public static void main(String[] args) {
        int numeroDeElementos = 20;
        List<Integer> numerosRandomicos = new Random()
                .ints(numeroDeElementos).map(x -> x % 100)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.print("Os numeros são:      ");
        numerosRandomicos.stream().forEach(x -> System.out.print(x + " "));

        System.out.print("\nOs antecessores são: ");
        numerosRandomicos.stream().forEach(x -> System.out.print((x - 1) + " "));

        System.out.print("\nOs sucessores são:   ");
        numerosRandomicos.stream().forEach(x -> System.out.print((x + 1) + " "));
    }
}
