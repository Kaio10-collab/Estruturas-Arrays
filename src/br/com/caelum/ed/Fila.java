package br.com.caelum.ed;

import java.util.LinkedList;
import java.util.List;

public class Fila {

    private final List<Aluno> alunos = new LinkedList<Aluno>();
    private final List<Fila> alunosFila = new LinkedList<Fila>();


    public void insere(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Aluno remove() {
        return this.alunos.remove(0);
    }

    public boolean vazia() {
        return this.alunosFila.size() == 0;
    }

}

//Vamos generalizá-la para poder armazenar
//qualquer tipo de objeto. Isso será feito utilizando a classe Object da qual todas as classe derivam direta ou
//indiretamente. Criaremos uma LinkedList de Object em vez de uma LinkedList de Aluno.
//public class Fila {
//private List<Object> objetos = new LinkedList<Object>();
//public void insere(Object objeto) {
//this.objetos.add(objeto);
//}
//public Object remove() {
//return this.objetos.remove(0);
//}
//public boolean vazia() {
//return this.objetos.size() == 0;
//}
//}
// Mas, há uma desvantagem, quando removemos um elemento da Fila não podemos garantir qual é o tipo de objeto que virá.
// A solução para este problema é utilizar o recurso do Generics. A nossa classe Fila vai ser uma classe parametrizada.
// public class Fila<T> {
//private List<T> objetos = new LinkedList<T>();
//public void insere(T t) {
//this.objetos.add(t);
//}
//public T remove() {
//return this.objetos.remove(0);
//}
//public boolean vazia() {
//return this.objetos.size() == 0;
//}
//}
