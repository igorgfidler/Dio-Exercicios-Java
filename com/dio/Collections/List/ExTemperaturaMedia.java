package com.dio.Collections.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

public class ExTemperaturaMedia {
    public static void main(String[] args) {
        int numeroTemperaturas = 6;
        List<Double> temperaturas = new ArrayList<>(numeroTemperaturas);
        int contador = 0;
        try (Scanner s = new Scanner(System.in)) {
            while (contador < numeroTemperaturas) {
                Optional<String> mes = generateMesFromNumbeOptional(contador + 1);
                System.out.print("Insira a temperatura média de " + mes.get() + ": ");
                while (!s.hasNextDouble()) {
                    System.out.println("Por favor insira um número.");
                }
                temperaturas.add(s.nextDouble());
                contador++;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.exit(1);
        }

        OptionalDouble optMedia = temperaturas.stream().mapToDouble(x -> x).average();
        double media = optMedia.getAsDouble();

        System.out.print("Os meses com a temperatura acima da média são: ");

        for (int i = 0; i < temperaturas.size(); i++) {
            if (temperaturas.get(i) > media) {
                Optional<String> mes = generateMesFromNumbeOptional(i + 1);
                if (mes.isPresent()) {
                    System.out.print(mes.get() + " ");
                } else {
                    System.out.println("Mes inválido");
                }
            }
        }
    }

    private static Optional<String> generateMesFromNumbeOptional(int numeroMes) {
        switch (numeroMes) {
            case 1:
                return Optional.ofNullable("Janeiro");
            case 2:
                return Optional.ofNullable("Fevereiro");
            case 3:
                return Optional.ofNullable("Março");
            case 4:
                return Optional.ofNullable("Abril");
            case 5:
                return Optional.ofNullable("Maio");
            case 6:
                return Optional.ofNullable("Junho");
            default:
                return Optional.ofNullable(null);
        }
    }
}
