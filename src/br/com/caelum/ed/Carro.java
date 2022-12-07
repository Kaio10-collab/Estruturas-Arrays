package br.com.caelum.ed;

//Um requisito fundamental para o Mapa é que as chaves sejam únicas. Não pode existir dois carros com a mesma placa, dois canais de televisão no mesmo número ou dois pedidos de números iguais.
//Os Mapas são as estruturas de dados que implementam o tipo de situação que estamos discutindo aqui.
//1) Adicionar uma associação.
//2) Pegar um valor dado uma chave.
//3) Remover uma associação dado uma chave.
//4) Verificar se existe uma associação para uma determinada chave.
//5) Informar a quantidade de associações.

public class Carro {

    private String nome;
    private String marca;
    private String cor;
    private int ano;

    public Carro(String a) {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}