package br.com.caelum.ed;

//O ponto fundamental do Mapa é a associação das chaves com os valores. Para modelar uma associação, vamos definir essa classe.
//O nosso Mapa está atrelado fortemente a associações entre String e Carro. Podemos generalizá-lo e parametrizá-lo para reutilizá-lo em diversas situações.

public class Associacao<C, V> {

    private C chave;
    private V valor;

    public Associacao(C chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }
    public C getChave() {
        return chave;
    }
    public V getValor() {
        return valor;
    }
    @Override
    public String toString() {
        return "{" + this.chave + " -> " + this.valor + "}";
    }

    public String getPlaca() {
        return null;
    }

    public Carro getCarro() {
        return null;
    }

}
