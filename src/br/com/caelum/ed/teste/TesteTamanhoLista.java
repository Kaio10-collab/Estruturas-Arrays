package br.com.caelum.ed.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Vetor;

public class TesteTamanhoLista {

    public static void main(String[] args) {

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        a1.setNome("Rafael");
        a2.setNome("Paulo");

        Vetor lista = new Vetor();

        lista.adiciona(a1);
        lista.adiciona(a2);
        System.out.println(lista.tamanho());

        lista.adiciona(a3);
        System.out.println(lista.tamanho());
    }

    //public static void main(String[] args) {
    //ListaLigada lista = new ListaLigada();
    //lista.adiciona("Rafael");
    //lista.adiciona("Paulo");
    //System.out.println(lista.tamanho());
    //lista.adiciona("Camila");
    //System.out.println(lista.tamanho());
    //}


}
