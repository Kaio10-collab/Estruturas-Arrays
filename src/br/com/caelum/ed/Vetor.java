package br.com.caelum.ed;

public class Vetor {

    // Declarando e Inicializando um array de Aluno com capacidade 100.
    // Em vez de colocarmos um array de Aluno na classe Vetor vamos colocar um array de Object. Assim,
    //estamos generalizando a nossa estrutura de dados. Desta forma, poderemos armazenar qualquer tipo de
    //objeto.
    private Aluno[] alunos = new Aluno[100];

    private int totalDeAlunos = 0;

    // Para achar a última posição da Lista ou a primeira posição vazia basta percorrer o array da esquerda para
    // a direita até achar um valor null (lembrando que os arrays do Java guardam referências, e o valor padrão para
    // referências é null).Para percorrer o array usaremos um laço. Perceba que usamos o controlador de laço break para parar o for
    // quando o aluno já foi adicionado.
    // public class Vetor {
    // private Aluno[] alunos = new Aluno[100];
    // public void adiciona(Aluno aluno) {
    // for (int i = 0; i < this.alunos.length; i++) {
    // if (this.alunos[i] == null) {
    // this.alunos[i] = aluno;
    // break;
    // Aqui o consumo será LINEAR
    public void adiciona(Aluno aluno) {
        this.garantaEspaco();
        this.alunos[this.totalDeAlunos] = aluno;
        this.totalDeAlunos++;
    }
    // Agora no método acima, o consumo de tempo do método é sempre o mesmo não importa quantos alunos estejam armazenados.
    // Neste caso, dizemos que o consumo é constante.
    // Adicionamos uma verificação se existe espaço disponível antes de adicionar um aluno. Também foi aplicado no método adiciona abaixo(linha 31)

    public void adiciona(int posicao, Aluno aluno) {
        this.garantaEspaco();
        if (!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        for (int i = this.totalDeAlunos - 1; i >= posicao; i--) {
            this.alunos[i + 1] = this.alunos[i];
        }
        this.alunos[posicao] = aluno;
        this.totalDeAlunos++;
    } // Desloca as posições para a direita para encaixa o novo aluno. Se for para a última posição irá consumir o tempo constante, se desloca as outras posições para a direita, será consumido tempo linear.

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= this.totalDeAlunos;
    } // método para isolar a verificação da posição para adicionar um aluno

    public Object pega(int posicao) {
        if (this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        return this.alunos[posicao];
    } // aqui devemos acessar e devolver o aluno da posição desejada. Neste formato corremos o risco de acessar posição
    // vazia ou inexistente. Então precisaremos criar um método para verificar se esta ocupada, chamada de posicaoOcupada.

    private boolean posicaoOcupada(int posicao) {
        return posicao < 0 || posicao >= this.totalDeAlunos;
    }
    public void remove(int posicao) {
        if (this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        for (int i = posicao; i < this.totalDeAlunos - 1; i++) {
            this.alunos[i] = this.alunos[i + 1];
        }
        this.totalDeAlunos--;
    } // aqui ele verifica se a posição esta preenchida, caso sim, ele remove e desloca as posições da direita para a posição removida.

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.totalDeAlunos; i++) {
            if (aluno.equals(this.alunos[i])) {
                return true;
            }
        }
        return false;
    } // verifica se um aluno está presente no vetor.
    // Neste método se for encontrado, o true é devolvido, caso o array acabe e não ache, irá devolver falso. Pois
    // A capacidade do array é obtido pelo atributo this.alunos.length(percorre o laço completo). Podemos
    // utilizar o atributo this.totalDeAlunos ao invés do length, pois ele pegaria a última posição ocupada.
    // Mas ai estamso comparando a referências e não objetos. PAra contornar isso, colocamos o equals(Object).

    public int tamanho() {
        return this.totalDeAlunos;
    } // informa o tamanho da Lista.
    //Esta operação ficou muito simples de ser implementada porque a classe Vetor tem um atributo que guarda
    //a quantidade de alunos armazenados. Então, basta devolver o valor do totalDeAlunos.
    // Se não tivessemos criado o atributo totalDeAlunos o método tamanho() teria que fazer um laço para percorrer o array inteiro e
    // contar quantas posições estão ocupadas. Ou seja, o desempenho seria linear que é muito pior que constante.
    // Com isso o consumo de tempo será constante e não terá laço.

    public String toString() {
        if (this.totalDeAlunos == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.totalDeAlunos - 1; i++) {
            builder.append(this.alunos[i]);
            builder.append(", ");
        }
        builder.append(this.alunos[this.totalDeAlunos - 1]);
        builder.append("]");

        return builder.toString();
    }

    private void garantaEspaco() {
        if (this.totalDeAlunos == this.alunos.length) {
            Aluno[] novaArray = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++) {
                novaArray[i] = this.alunos[i];
            }
            this.alunos = novaArray;
        }
    } // o array possui apenas 100 posições, logo quando atingir será criado outro array com o dobro do tamanho e trasnferir as posições do array anterior por atual.


}
//No Java todas as classes herdam, diretamente ou indiretamente, da classe Object. Então, um objeto de
//qualquer tipo pode ser referenciado com uma variável do tipo Object. Este conceito de referenciar um mesmo
//objeto de várias maneira (Aluno ou Object) é chamado de polimorfismo.
//O que ganhamos com esta generalização foi um forte reaproveitamento da classe Vetor, porém na hora do
//uso perdemos a segurança da tipagem do java. Isso acarretará na necessidade do uso de casting.