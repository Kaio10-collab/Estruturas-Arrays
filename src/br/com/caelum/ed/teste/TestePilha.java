package br.com.caelum.ed.teste;

import br.com.caelum.ed.Peca;
import br.com.caelum.ed.Pilha;

public class TestePilha {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Peca pecaInsere = new Peca();
        pilha.insere(pecaInsere);
        Peca pecaRemove = pilha.remove();
        if (pilha.vazia()) {
            System.out.println("A pilha está vazia");
        }
    }

}
