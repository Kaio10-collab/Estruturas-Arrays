package br.com.caelum.ed.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Vetor;

public class TesteAdicionaPorPosicao {

    public static void main(String[] args) {

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        a1.setNome("Rafael");
        a2.setNome("Paulo");
        a3.setNome("Ana");

        Vetor lista = new Vetor();

        lista.adiciona(a1);
        lista.adiciona(0, a2);
        lista.adiciona(1, a3);

        System.out.println(lista);

       // public static void main(String[] args) {
          //  ListaLigada lista = new ListaLigada();
        //    lista.adiciona("Rafael");
          //  lista.adiciona(0, "Paulo");
         //   lista.adiciona(1, "Camila");
        //    System.out.println(lista);
    }

}
