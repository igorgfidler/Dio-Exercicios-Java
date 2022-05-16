package com.dio.repeticao_e_array.exercicios.repeticao;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex2_Nota {
    public static void main(String[] args) {
        boolean doneReading = false;
        Scanner s = new Scanner(System.in);
        while (!doneReading) {
            try {
                System.out.print("Nota: ");
                double nota = s.nextDouble();

                while (nota < 0.0d || nota > 10.0d) {
                    System.out.print("Nota inválida, por favor insira novamente: ");
                    nota = s.nextDouble();
                }
                // input is valid over here
                doneReading = true;
                System.out.println("A nota: " + nota + " é válida");
            } catch (InputMismatchException e) {
                System.out.println("Por Favor insira um número");
                s.next();
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Ocorreu um erro inexperado");
                System.exit(1);
            }
        }
        s.close();

    }

}
