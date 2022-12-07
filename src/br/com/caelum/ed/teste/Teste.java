package br.com.caelum.ed.teste;

import br.com.caelum.ed.Aluno;

import java.util.LinkedList;

public class Teste {

    public static void main(String[] args) {
        Aluno paulo = new Aluno();
        paulo.setNome("paulo silveira");
        Aluno rafael = new Aluno();
        rafael.setNome("rafael cosentino");
        Aluno fiodor = new Aluno();
        fiodor.setNome("fiodor dostoievski");

        //A classe LinkedList faz o papel da nossa Lista Ligada dentro da bibilioteca do Java. Ela possui os
        //mesmos métodos que a ArrayList, e adiciona alguns outros, como o addFirst(Object), removeFirst(),
        //addLast(Object) e removeLast(), que operam no começo e no fim da Lista em tempo constante.
        LinkedList listaLigada = new LinkedList();
        listaLigada.add(paulo);
        listaLigada.add(rafael);
        listaLigada.add(1, fiodor);
        for (int i = 0; i < listaLigada.size(); i++) {
            System.out.println(listaLigada.get(i));
        }

    }

}
