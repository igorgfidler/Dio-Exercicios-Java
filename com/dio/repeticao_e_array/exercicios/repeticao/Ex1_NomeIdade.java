package com.dio.repeticao_e_array.exercicios.repeticao;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/*
Faça um programa que leia conjuntos de dois valores,
o primeiro representando o nome do aluno e o segundo representando a sua idade.
(Pare o programa inserindo o valor 0 no campo nome)
*/

public class Ex1_NomeIdade {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Insira o seu nome: ");
                String nome = s.next();

                if (nome.equals("0"))
                    break;
                cls();
                System.out.println("\rInsira o seu nome: " + nome);
                System.out.print("Insira a sua idade: ");
                int idade = s.nextInt();
                System.out.println("Nome: " + nome + ".");
                System.out.println("Idade: " + idade + " anos.\n");

            } catch (InputMismatchException e) {
                cls();
                System.out.println("A idade dever ser um número");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                // Estamos lidando com System.in, então sempre haverá o que ler.
                // Essas excessões nunca deverão ocorrer
                System.out.println("Algo ocorreu de errado e não há nada mais para ler no input");
                System.exit(1);
            }
        }
        s.close();
    }

    public static void cls() {
        try {

            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }
}