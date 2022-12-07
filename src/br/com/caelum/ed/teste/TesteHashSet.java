package br.com.caelum.ed.teste;

import java.util.HashSet;

public class TesteHashSet {

    //Na biblioteca do Java há uma classe que faz exatamente o que fizemos neste capítulo, implementar um
    //Conjunto genérico utilizando a técnica de espalhamento. Esta classe é a HashSet.

    public static void main(String[] args) {
        HashSet conjunto = new HashSet();
        conjunto.add("Rafael");
        conjunto.add("Rafael");
        conjunto.add("Ana");
        conjunto.add("Paulo");
        System.out.println(conjunto);
    }
}
