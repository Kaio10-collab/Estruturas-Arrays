package br.com.caelum.ed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ConjuntoEspalhamentoParametrizado<T> {

    //A nossa implementação de Conjunto usando a técnica de Espalhamento funciona apenas para armazenar
    //palavras (Strings). Estamos amarrando a estrutura de dados ao tipo de dado que ela vai guardar. Seria melhor
    //generalizar o nosso Conjunto.
    //Assim como fizemos em capítulos anteriores, vamos trocar os tipos específicos por referências da classe
    //Object. Diferentemente das outras estruturas que implementamos até o momento, a generalização do Conjunto
    //será um pouco mais delicada.
    //O problema é o calculo do Código de Espalhamento. Este calculo depende do tipo do objeto. Para gerar um
    //bom Código de Espalhamento o Conjunto deveria conhecer as características de todos os tipo de objetos. Isso
    //seria inviável.
    //A solução é deixar alguém que conhece muito bem as características do objeto a ser armazenado no Conjunto gerar o Código de Espalhamento. Quem melhor conhece um objeto e a classe dele. Então, as classes
    //dos objetos que precisam ser armazenados devem definir como gerar o Código de Espalhamento.
    //No Java, a classe Object define um método para gerar o Código de Espalhamento. Este método é o
    //hashCode(). Eventualmente, você pode reescrever este método para implementar o seu Código de Espalhamento ou pode utilizar o que está feito em Object.

    private List<List<T>> tabela = new ArrayList<List<T>>();
    private int tamanho = 0;

    public ConjuntoEspalhamentoParametrizado() {
        for (int i = 0; i < 26; i++) {
            LinkedList<T> lista = new LinkedList<T>();
            tabela.add(lista);
        }
    }
    public void adiciona(T objeto) {
        if (!this.contem(objeto)) {
            this.verificaCarga();
            int indice = this.calculaIndiceDaTabela(objeto);
            List<T> lista = this.tabela.get(indice);
            lista.add(objeto);
            this.tamanho++;
        }
    }
    public void remove(T objeto) {
        if (this.contem(objeto)) {
            int indice = this.calculaIndiceDaTabela(objeto);
            List<T> lista = this.tabela.get(indice);
            lista.remove(objeto);
            this.tamanho--;
            this.verificaCarga();
        }
    }
    public List<T> pegaTodos() {
        List<T> objetos = new ArrayList<T>();
        for (int i = 0; i < this.tabela.size(); i++) {
            objetos.addAll(this.tabela.get(i));
        }
        return objetos;
    }
    public boolean contem(T objeto) {
        int indice = this.calculaIndiceDaTabela(objeto);
        List<T> lista = this.tabela.get(indice);
        return lista.contains(objeto);
    }
    public int tamanho() {
        return this.tamanho;
    }
    private int calculaIndiceDaTabela(T objeto) {
        int codigoDeEspalhamento = objeto.hashCode();
        codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
        return codigoDeEspalhamento % tabela.size();
    }
    private void redimensionaTabela(int novaCapacidade) {
        List<T> objetos = this.pegaTodos();
        this.tabela.clear();
        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.add(new LinkedList<T>());
        }
        for (T objeto : objetos) {
            this.adiciona(objeto);
        }
    }
    private void verificaCarga() {
        int capacidade = this.tabela.size();
        double carga = (double) this.tamanho / capacidade;
        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
        }
    }
    public void imprimeTabela() {
        for (List<T> lista : this.tabela) {
            System.out.print("[");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("*");
            }
            System.out.println("]");
        }
    }
}
