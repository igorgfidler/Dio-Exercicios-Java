package com.dio.Collections.Set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome = null;
    private int anoCriacao = 0;
    private String ide = null;

    LinguagemFavorita(String nome, int anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public static void main(String[] args) {
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>();
        LinguagemFavorita rust = new LinguagemFavorita("Rust", 2015, "VScode");
        LinguagemFavorita haskell = new LinguagemFavorita("Haskell", 2010, "Emacs");
        LinguagemFavorita java = new LinguagemFavorita("Java", 1990, "Intellij");
        linguagens.add(rust);
        linguagens.add(haskell);
        linguagens.add(java);

        System.out.println("-------- Mostrando por ordem de inserção --------");
        System.out.println(linguagens);

        System.out.println("-------- Mostrando por order de nome ---------");
        linguagens.stream().sorted().forEach(x -> System.out.println(x));

        /*
         * estou usando funções anonimas pois não é necessário reutiliza-las
         * se necessário pode ser implementada a interface Comparetor
         */
        System.out.println("---------- Mostrando por ordem de ide --------");
        linguagens.stream().sorted((x, y) -> {
            return x.ide.compareTo(y.ide);
        }).forEach(x -> System.out.println(x));

        System.out.println("----------- Mostrando por ano de criação e nome ------");
        linguagens.stream().sorted((x, y) -> {
            if ((x.anoCriacao - y.anoCriacao) != 0) {
                return x.anoCriacao - y.anoCriacao;
            } else {
                return x.nome.compareTo(y.nome);
            }
        }).forEach(x -> System.out.println(x));

        System.out.println("-------------- Mostrando por nome, ano de criação e ide");
        linguagens.stream().sorted((x, y) -> {
            int ordenacaoNome = x.nome.compareTo(y.nome);
            int ordenacaoAno = x.anoCriacao - y.anoCriacao;
            int ordenacaoIde = x.ide.compareTo(y.ide);
            if (ordenacaoNome != 0) {
                return ordenacaoNome;
            } else if (ordenacaoAno != 0) {
                return ordenacaoAno;
            } else {
                return ordenacaoIde;
            }

        }).forEach(x -> System.out.println(x));
    }

    public String getNome() {
        return this.nome;
    }

    public int getAnoCriacao() {
        return this.anoCriacao;
    }

    public String getIde() {
        return this.ide;
    }

    @Override
    public int compareTo(LinguagemFavorita o) {
        return this.nome.compareTo(o.nome);
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("\nNome: " + this.nome + "\n");
        retorno.append("Ano de criação: " + this.anoCriacao + "\n");
        retorno.append("IDE: " + this.ide + "\n");
        return new String(retorno);
    }
}

/* implementando as comparações propostas */

class CompareLinguagemPorIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareTo(o2.getIde());
    }

}

class CompareLinguagemPorAnoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ordenacaoAno = o1.getAnoCriacao() - o2.getAnoCriacao();
        int ordenacaoNome = o1.getNome().compareTo(o2.getNome());
        if (ordenacaoAno != 0) {
            return ordenacaoAno;
        } else {
            return ordenacaoNome;
        }
    }

}

class CompareLinguagemPorNomeAnoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ordenacaoNome = o1.getNome().compareTo(o2.getNome());
        int ordenacaoAno = o1.getAnoCriacao() - o2.getAnoCriacao();
        int ordenacaoIde = o1.getIde().compareTo(o2.getIde());
        if (ordenacaoNome != 0) {
            return ordenacaoNome;
        } else if (ordenacaoAno != 0) {
            return ordenacaoAno;
        } else {
            return ordenacaoIde;
        }
    }

}