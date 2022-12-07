package br.com.caelum.ed;

import java.util.LinkedList;
import java.util.List;

public class Pilha {

    //Qual é a diferença entre uma Lista e uma Pilha? A diferença está nas operações destas duas estruturas
    //de dados. As operações de uma Pilha são mais restritas do que as de uma Lista. Por exemplo, você pode
    //adicionar ou remover um elemento em qualquer posição de uma Lista mas em uma Pilha você só pode adicionar
    //ou remover do topo.

    //Nossa Pilha só funciona para guardar objetos da classe Peca. Vamos generalizar a Pilha para poder armazenar qualquer tipo de objeto. Isso será feito utilizando a classe Object da qual todas as classe derivam direta
    //ou indiretamente. Criaremos uma LinkedList de Object em vez de uma LinkedList de Peca.

    private List<Peca> pecas = new LinkedList<Peca>();

    //As peças são sempre inseridas no topo da Pilha. Ainda não definimos onde fica o topo da Pilha. Como
    //estamos utilizando uma Lista para guardar os elementos então o topo da Pilha poderia ser tanto o começo ou o
    //fim da Lista. Aqui escolheremos o fim da Lista.
    //Então, inserir na Pilha é simplesmente adicionar no fim da Lista
    public void insere(Peca peca) {
        this.pecas.add(peca);
    }
    public Peca remove() {
        return this.pecas.remove(this.pecas.size() - 1);
    }
    public boolean vazia() {
        return this.pecas.size() == 0;

    }

}
