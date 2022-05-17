package com.dio.Collections.List;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExDetetive {
    public static void main(String[] args) {
        List<String> perguntas = Stream.of("Telefonou para a vítima?",
                "Esteve no local do crime?",
                "Mora perto da vítima?",
                "Devia para a vítima?",
                "Já trabalhou para a vítima?").collect(Collectors.toList());
        int nivelSuspeito = 0;
        Scanner s = new Scanner(System.in);
        for (String pergunta : perguntas) {
            System.out.println(pergunta + "(s/n)");
            String resposta = s.next();
            if (resposta.toLowerCase().startsWith("s")) {
                nivelSuspeito++;
            }
        }
        s.close();
        System.out.println("O indivíduo investigado é: " + gerarVeredito(nivelSuspeito));
    }

    private static String gerarVeredito(int nivelSuspeito) {
        switch (nivelSuspeito) {
            case 2:
                return "Suspeito";
            case 3:
            case 4:
                return "Cúmplice";
            case 5:
                return "Assassino";
            default:
                return "Inocente";
        }
    }
}
