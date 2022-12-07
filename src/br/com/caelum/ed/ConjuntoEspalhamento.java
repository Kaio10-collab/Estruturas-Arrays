package br.com.caelum.ed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento {

    private List<List<String>> tabela = new ArrayList<List<String>>();
    private int tamanho = 0;

    //Precisamos definir quantas posições a Tabela terá, ou seja, quantas Listas secundárias devemos ter, e
    //inicializar cada uma delas. Isso pode ser feito no construtor da nossa classe. Inicialmente, teremos 26 posições
    //na Tabela, uma para cada letra do alfabeto. Aqui vamos separar as palavras de acordo com a primeira letra
    //delas: essa será nossa Função de Espalhamento. Assim como nas agendas de contatos de antigamente.
    public ConjuntoEspalhamento() {
        for (int i = 0; i < 26; i++) {
            LinkedList<String> lista = new LinkedList<String>();
            tabela.add(lista);
        }
    }
    //Observe que foram utilizados os métodos toLowerCase() e chatAt(int) da classe String. O primeiro devolve a palavra em letras minúsculas. O segundo devolve o caracter na posição passada como parâmetro. Além
    //disso, foi feito uma operação de Resto da Divisão. Isso parece estranho mas faz todo o sentido visto que cada
    //caracter tem um valor inteiro positivo.

    //A nossa Função deve observar a primeira letra das palavras e calcular o índice correto na Tabela. Por
    //exemplo, palavras começadas com “a” devem ir para uma posição, palavras começadas com “b” devem ir para
    //outra 1 e assim por diante até a letra “z”.
    //Vamos fazer um método para implementar a Função de Espalhamento. Este método deve receber uma
    //String (palavra) e devolver um int (índice associado a palavra).
    //Agora, o método calculaIndiceDaTabela(String) simplesmente usa o método calculaCodigoDeEspalhamento para obter o Código de Espalhamento e a partir dele calcula um índice
    //válido para a Tabela (isto é, dentro dos índices da tabela):
    private int calculaIndiceDaTabela(Object objeto) {
        int codigoDeEspalhamento = objeto.hashCode();
        codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
        return codigoDeEspalhamento % this.tabela.size();
    }

    //Para adicionar uma palavra no Conjunto, devemos aplicar a Função de Espalhamento para descobrir em
    //qual posição da Tabela devemos adicionar. Depois, recuperamos a Lista que está nesta posição para guardar
    //a palavra.
    //O requisito fundamental de um Conjunto é não ter elementos repetidos. Como as Listas permitem elementos repetidos se adcionarmos duas vezes a mesma palavra ela
    //será inserida duas vezes.
    //Podemos evitar a repetição de palavras fazendo uma pequena verificação antes de adicionar uma palavra.
    //Utilizamos o método contem(String) para saber se o Conjunto já contém a palavra. Se contém o adiciona(String) não faz nada.
    public void adiciona(String palavra) {

        if (!this.contem(palavra)) {
            int indice = this.calculaIndiceDaTabela(palavra);
            List<String> lista = this.tabela.get(indice);
            lista.add(palavra);
        }
    }

    //Analogamente ao adiciona(String), o método remove(String) deve achar a posição da Tabela onde está
    //a Lista na qual a palavra a ser removida estaria. Depois, basta remover a palavra da Lista.
    //Antes de tentar remover poderíamos verificar se a palavra está no Conjunto. Nas Listas da API do Java,
    //existe uma sobrecarga do método de remover que recebe o próprio elemento, além do o qual recebe um índice.
    //Isto auxilia no nosso método:
    public void remove(String palavra) {

        if (this.contem(palavra)) {
            int indice = this.calculaIndiceDaTabela(palavra);
            List<String> lista = this.tabela.get(indice);
            lista.remove(palavra);
        }

    }

    //Esta operação é simples, basta achar o índice da Tabela aplicando a Função de Espalhamento da palavra
    //desejada e verificar se ela está na Lista correspondente.
    //Aqui está o grande truque para deixar nosso Conjunto mais rápido que uma simples lista: buscamos apenas
    //nos elementos que se encontram naquela “página da agenda”. Se o elemento não estiver lá, com certeza ele
    //não se encontra em nenhuma outra página da agenda. O nosso espalhamento tem uma certa organização que
    //facilita as buscas!
    public boolean contem(String palavra) {

        int indice = this.calculaIndiceDaTabela(palavra);
        List<String> lista = this.tabela.get(indice);
        return lista.contains(palavra);

    }

    //As palavras estão armazenadas na Tabela. Então, para recuperar todas as palavras, precisamos percorrer
    //todas as posições da Tabela. Em cada posição, há uma Lista, pegaremos todos os elementos de cada Lista e
    //armazenaremos em uma única Lista e a devolveremos.
    //Este método cria uma Lista do tipo ArrayList. Porém, observe que a referência é do tipo List. Isso é
    //possível por causa do Polimorfismo (capacidade de referênciar de várias maneiras um mesmo objeto). Todo objeto do tipo ArrayList também é do tipo List.
    //Todas as Listas do Java disponibilizam uma operação que permite adicionar diversos elementos de uma vez
    //só. Esta funcionalidade é implementada pelo método addAll(Collection). Este método foi utilizado dentro do
    //for para inserir na Lista de todas as palavras do Conjunto todas as palavras da Lista da posição i da Tabela.
    public List<String> pegaTodas() {

        List<String> palavras = new ArrayList<String>();

        for (int i = 0; i < this.tabela.size(); i++) {
            palavras.addAll(this.tabela.get(i));
        }
        return palavras;

    }

    //Para esta operação, temos duas alternativas ou em cada vez que a operação for executada nós percorremos
    //todas as Listas contanto os elementos ou fazemos de uma forma mais eficiente que é guardar em um atributo a
    //quantidade de palavras presentes no Conjunto. Este atributo deve ser incrementado toda vez que uma palavra
    //for adicionada e decrementado toda vez que uma palavra for removida.
    public int tamanho() {

        return this.tamanho;
    }

}