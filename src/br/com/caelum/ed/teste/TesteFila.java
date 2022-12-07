package br.com.caelum.ed.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Fila;

public class TesteFila {

    public static void main(String[] args) {
        Fila fila = new Fila();
        Aluno aluno = new Aluno();
        fila.insere(aluno);

        Aluno alunoRemovido = fila.remove();
        if (fila.vazia()) {
            System.out.println("A fila está vazia");
        }
    }
}
