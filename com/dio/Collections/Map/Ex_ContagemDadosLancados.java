package com.dio.Collections.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Ex_ContagemDadosLancados {
    public static void main(String[] args) {
        int numeroDeLancamentos = 100;
        Random rng = new Random(0);

        System.out.println("Usando um simples array");
        int[] dados = { 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < numeroDeLancamentos; ++i) {
            dados[rng.nextInt(6)] += 1;
        }

        for (int i = 1; i <= dados.length; ++i) {
            System.out.println("Dado " + i + " foi lançado " + dados[i - 1] + " vezes.");
        }

        System.out.println("Usando um mapa");
        rng.setSeed(0);

        Map<Integer, Integer> mapaDados = new HashMap<>();

        for (int i = 0; i < numeroDeLancamentos; ++i) {
            int dadoLancado = rng.nextInt(1, 7);
            if (mapaDados.containsKey(dadoLancado)) {
                int valorAntigo = mapaDados.get(dadoLancado);
                mapaDados.put(dadoLancado, valorAntigo + 1);
            } else {
                mapaDados.put(dadoLancado, 1);
            }
        }

        mapaDados.entrySet().stream().forEach(entry -> {
            System.out.println("O dado " + entry.getKey()
                    + " foi lançado "
                    + entry.getValue()
                    + " vezes.");
        });

    }
}
