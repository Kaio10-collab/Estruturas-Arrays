package br.com.caelum.ed.teste;

import br.com.caelum.ed.ListaLigada;

public class TesteAdicionaNoComeco {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.adicionaNoComeco("Rafael");
        lista.adicionaNoComeco("Paulo");
        System.out.println(lista);
    }

}
