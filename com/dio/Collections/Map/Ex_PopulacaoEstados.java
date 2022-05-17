package com.dio.Collections.Map;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Ex_PopulacaoEstados {
    public static void main(String[] args) {
        Map<String, Integer> populacaoEstados = new LinkedHashMap<>();
        // Criando o map com as populações do exercício
        populacaoEstados.put("PE", 9_616_621);
        populacaoEstados.put("AL", 3_351_543);
        populacaoEstados.put("CE", 9_187_103);
        populacaoEstados.put("RN", 3_534_265);

        // Atualizando a população de RN
        populacaoEstados.put("RN", 3_534_165);

        // checando se PB está no mapa, se não inserir a população do estado
        populacaoEstados.putIfAbsent("PB", 4_039_277);
        // Exibindo a população de PE
        System.out.println("População de PE " + populacaoEstados.get("PE") + " habitantes.");

        // Exibindo todos os estados e suas populações por ordem de inserção
        populacaoEstados.keySet().stream()
                .forEach(key -> System.out.println("(" + key + ", " + populacaoEstados.get(key) + ")"));

        // exibir o estado com a menor população
        Optional<String> estadoMenorPopulacao = populacaoEstados.keySet()
                .stream()
                .reduce((key1, key2) -> {
                    int populacaoPrimeiroEstado = populacaoEstados.get(key1);
                    int populacaoSegundoEstado = populacaoEstados.get(key2);
                    if (populacaoPrimeiroEstado < populacaoSegundoEstado) {
                        return key1;
                    } else {
                        return key2;
                    }
                });

        if (estadoMenorPopulacao.isPresent()) {
            System.out.println("O estado com a menor população é: "
                    + estadoMenorPopulacao.get() + " com "
                    + populacaoEstados.get(estadoMenorPopulacao.get())
                    + " habitantes.");
        }

        // Exibir o estado com a maior população
        Optional<String> estadoMaiorPopulacao = populacaoEstados.keySet()
                .stream()
                .reduce((key1, key2) -> {
                    int populacaoPrimeiroEstado = populacaoEstados.get(key1);
                    int populacaoSegundoEstado = populacaoEstados.get(key2);
                    if (populacaoPrimeiroEstado > populacaoSegundoEstado) {
                        return key1;
                    } else {
                        return key2;
                    }
                });

        if (estadoMaiorPopulacao.isPresent()) {
            System.out.println("O estado com a maior população é: "
                    + estadoMaiorPopulacao.get() + " com "
                    + populacaoEstados.get(estadoMaiorPopulacao.get())
                    + " habitantes.");
        }

        // Soma da população dos estados
        Optional<Integer> somaDasPopulacoes = populacaoEstados
                .values()
                .stream()
                .reduce(Integer::sum);
        if (somaDasPopulacoes.isPresent()) {
            System.out.println("A soma das populações dos estados é: " + somaDasPopulacoes.get());
        }

        // Media das populações dos estados
        OptionalDouble mediaDasPopulacoes = populacaoEstados.values()
                .stream()
                .mapToInt(x -> x)
                .average();

        if (mediaDasPopulacoes.isPresent()) {
            System.out.println("A média das populações é de "
                    + mediaDasPopulacoes.getAsDouble()
                    + " habitantes");
        }

        // Remover os estados com população menor que 4.000.000
        int limiteInferiorPopulacao = 4_000_000;
        List<String> estadosParaRemover = populacaoEstados.keySet()
                .stream()
                .filter(key -> {
                    if (populacaoEstados.get(key) < limiteInferiorPopulacao) {
                        return true;
                    } else {
                        return false;
                    }
                }).collect(Collectors.toList());

        estadosParaRemover.stream().forEach(key -> populacaoEstados.remove(key));

        System.out.println("Estados com a população maior que "
                + limiteInferiorPopulacao
                + " habitantes");

        populacaoEstados.keySet().stream()
                .forEach(key -> System.out.println("(" + key + ", " + populacaoEstados.get(key) + ")"));

        // apagando o mapa
        populacaoEstados.clear();

        // Conferindo se está vazio
        if (populacaoEstados.isEmpty()) {
            System.out.println("O dicionário está vazio");
        }
    }
}
