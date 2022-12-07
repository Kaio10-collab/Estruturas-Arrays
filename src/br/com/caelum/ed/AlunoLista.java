package br.com.caelum.ed;

public class AlunoLista {

    //Uma array é uma estrutura fixa na memória, precisamos sempre empurrar todos seus vizinhos para um lado
    //para conseguir espaço, ou para remover algum dos elementos, para não deixar espaços vazios.
    //Então a idéia aqui é ter uma forma de, dado um aluno, saber quem é o próximo, sem usar uma estrutura
    //fixa. Podemos mudar a própria classe Aluno modificada! Repare no código abaixo.

    private String nome;
    private int idade;
    private AlunoLista proximo;

}
