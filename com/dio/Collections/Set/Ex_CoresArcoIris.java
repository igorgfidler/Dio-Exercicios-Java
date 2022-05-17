package com.dio.Collections.Set;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex_CoresArcoIris {
    public static void main(String[] args) {
        Set<String> coresArcoIris = Stream.of("Vermelho", "Laranja", "Amarelo",
                "Verde", "Azul", "Violeta").collect(Collectors.toCollection(LinkedHashSet::new));

        // Exibindo todas as cores, uma abaixo da outra
        System.out.println(coresArcoIris);

        // Exibindo a quantia de cores que o arco-íris possui
        System.out.println("O arco-íris possui " + coresArcoIris.size() + " cores.");

        // Exibindo as cores em ordem alfabética
        List<String> coresEmOrdemAlfabetica = coresArcoIris.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(coresEmOrdemAlfabetica);
        // Exibindo as cores em ordem inversa de inserção
        LinkedList<String> insercaoReversa = coresArcoIris.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        Collections.reverse(insercaoReversa);

        System.out.print("Mostrando a ordem inversa de inserção: " + insercaoReversa);

        System.out.println();

        // Exibindo as cores que começam com V
        System.out.print("Cores que começam com V: ");
        List<String> coresComecamV = coresArcoIris.stream()
                .filter(color -> color.startsWith("V"))
                .collect(Collectors.toList());
        System.out.println(coresComecamV.toString());

        // removendo as cores que começam com v
        coresComecamV.stream().forEach(color -> coresArcoIris.remove(color));

        // limpando o conjunto
        coresArcoIris.clear();
        if (coresArcoIris.isEmpty()) {
            System.out.println("O conjunto está vazio");
        }
    }
}