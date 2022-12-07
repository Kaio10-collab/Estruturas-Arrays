package br.com.caelum.ed;

//A maneira mais simples de implementar um Mapa é guardar as associações pertencentes a ele em uma Lista.
//Como sabemos quais operações queremos podemos definir o “esqueleto” da classe que vai implementar o Mapa.

import java.util.ArrayList;
import java.util.List;

public class MapaLista {

    private List<Associacao> associacoes = new ArrayList<Associacao>();

//Antes de adicionar uma associação no Mapa devemos verificar se a chave da nova associação não pertence a alguma associação da Lista.
//Para remover uma associação, verificar se uma chave está associada a um valor ou recuperar o valor associado a uma determinada chave é necessário percorrer a Lista.
//O Mapa não pode permitir duas associações com a mesma chave. Então, fazemos uma verificação para saber se a chave já está no Mapa. Utilizamos o método contemChave(String) para este teste

//Esta operação é bem eficiente porque adicionar no fim de qualquer tipo de Lista é muito rápido. Poderíamos ter escolhido uma outra decisão aqui: se a chave já existisse, trocamos o valor associado para
//este novo Carro. A API do Java trata isso desta maneira.
    public void adiciona(String placa, Carro carro) {
        if (!this.contemChave(placa)) {
            Associacao associacao = new Associacao(placa, carro);
            this.associacoes.add(associacao);
        }
    }

    //Da maneira que foi implementado devemos percorrer todas as associações para achar a desejada. Se a
    //chave não estiver presente no Mapa uma exceção é lançada.
    //Este método também deve percorrer a Lista de associações. Então o consumo de tempo é linear.
    public Carro pega(String placa) {
        for (Associacao associacao : this.associacoes) {
            if (placa.equals(associacao.getPlaca())) {
                return associacao.getCarro();
            }
        }
        throw new IllegalArgumentException("chave não existe");
    }

//Comparamos a chave recebida no parâmetro com as chaves de todas as associações da Lista. Se alguma
//for igual então marcamos a associação para remover. Não podemos remover dentro do for por causa da
//concorrência. Se o Mapa não tem uma associação com a chave procurada então uma exceção é lançada.
    //O consumo de tempo deste método também é linear
    public void remove(String placa) {
        if (this.contemChave(placa)) {
            for (int i = 0; i < this.associacoes.size(); i++) {
                Associacao associacao = this.associacoes.get(i);
                if (placa.equals(associacao.getPlaca())) {
                    this.associacoes.remove(i);
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("chave não existe");
        }
    }

    //Esta operação é simples, basta percorrer a Lista e comparar as chaves. Logo o consumo de tempo será
    //linear.
    public boolean contemChave(String placa) {
        for (Associacao associacao : this.associacoes) {
            if (placa.equals(associacao.getPlaca())) {
                return true;
            }
        }
        return false;
    }

    //Como todas as associações estão armazenadas em uma Lista, o tamanho do Mapa é o tamanho da Lista.
    public int tamanho() {
        return this.associacoes.size();
    }

}
