package br.com.caelum.ed.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Vetor;

public class TesteRemovePorPosicao {

    public static void main(String[] args) {

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        a1.setNome("Rafael");
        a2.setNome("Paulo");

        Vetor lista = new Vetor();

        lista.adiciona(a1);
        lista.adiciona(a2);

        lista.remove(0);

        System.out.println(lista);
    }

    //public static void main(String[] args) {
    //ListaLigada lista = new ListaLigada();
    //lista.adiciona("Rafael");
    //lista.adiciona("Paulo");
    //lista.adiciona("Camila");
    //lista.remove(1);
    //System.out.println(lista);
    //}
}
