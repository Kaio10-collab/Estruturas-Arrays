package br.com.caelum.ed;

public class ListaLigada {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;
    private int totalDeAlunos;

    //Para inserir um elemento em qualquer posição precisamos pegar a célula anterior a da posição desejada,
    //porque precisamos mexer na sua referência proxima. Para isso vamos criar um método auxiliar que pega
    //determinada célula. Este método deve tomar cuidado com o caso da posição não existir. A verificação se a
    //posição existe ou não é feita pelo método posicaoOcupada(int).
    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDeElementos;
    }
    private Celula pegaCelula(int posicao) {
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    //Se não tivessemos guardado a referência para a última célula precisaríamos percorrer célula a célula até o
    //fim da Lista para alterar a referência proxima da última célula! Com um grande número de elementos isso ficaria
    //lento, pois leva tempo linear.
    //No caso especial da Lista estar vazia, adicionar no começo ou no fim dessa lista dá o mesmo efeito. Então,
    //se a Lista estiver vazia, chamaremos o método adicionaNoComeco(Object).
    //No caso em que a Lista está vazia, adicionar no fim é a mesma coisa que adicionar no começo.
    //Agora, caso a Lista não esteja vazia então devemos ajustar as referências de tal forma que a nova última
    //célula aponte para a nova penúltima (antiga última) e vice versa.
    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;

        }
    }

    //Sobra o caso em que a inserção é no meio da Lista, ou seja, entre duas células existentes. Neste caso,
    //devemos ajustar as referências para a nova célula ser apontada corretamente pela duas células relacionadas a
    //ela (a anterior e a proxima). E também fazer a nova célula apontar para a anterior e a próxima.
    public void adiciona(int posicao, Object elemento) {
        if(posicao == 0){ // No começo.
            this.adicionaNoComeco(elemento);
        } else if(posicao == this.totalDeElementos){ // No fim.
            this.adiciona(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    //Para pegar um elemento é muito fácil: basta pegarmos a célula em que aquele elemento se encontra e
    //acessar o elemento de dentro dela. Podemos utilizar o pegaCelula(int) previamente criado:
    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }
    //Perceba que este método consome tempo linear. Esta é uma grande desvantagem da Lista Ligada em
    //relação aos Vetores. Vetores possuem o chamado acesso aleatório

    //devemos verificar se a posição está ou não ocupada. Se não estiver devemos lançar uma
    //exceção. Caso contrário, devemos verificar se a remoção é do começo ou do fim da Lista se for um destes
    //casos simplesmente chamamos os métodos que já fizemos.
    //Por fim, se a remoção é no interior da Lista devemos atualizar as referências das células relacionadas a
    //célula que vamos remover (anterior e próxima). A próxima da anterior deve ser a proxima e a anterior da
    //proxima deve ser a anterior.
    public void remove(int posicao){
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();
            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            this.totalDeElementos--;
        }
    }

    //Está operação não tem segredo, pois já temos um atributo que possui esta informação.
    public int tamanho() {
        return this.totalDeElementos;
    }

    //Está operação deve percorrer a Lista e comparar com o método equals(Object) o elemento procurado
    //contra todos os elementos da Lista.
    public boolean contem(Object elemento) {Celula atual = this.primeira;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }

    //Inserir no começo da Lista é bastante trivial, basta criarmos uma nova célula, e esta nova célula terá a
    //referência proxima apontando para a atual primeira da lista. Depois atualizamos o atributo primeira para se
    //referenciar a esta nova célula recém criada.
    //Se a Lista está vazia então a nova celula será a primeira e a última. Além disso, ela não terá próxima nem
    //anterior pois ela será a única célula.
    //Se a Lista não está vazia então devemos ajustar os ponteiros para a nova segunda (antiga referência
    //primeira) apontar para a nova primeira e vice versa.
    public void adicionaNoComeco(Object elemento) {
        if(this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;

    }
    public void removeDoComeco() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;
        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }
    public void removeDoFim() {
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }

    //Aqui estamos utilizando a classe StringBuilder que é muito útil para criar Strings potencialmente grandes,
    //em vez de concatenar Strings pelo operador +[label o fato da classe String do java ser imutável acarreta num
    //grande gasto de memória temporária no caso de você concatenas muitas Strings, vale a pena consultar a
    //documentação da mesma][/label].
    //Também poderíamos ter utilizado um while(atual != null) em vez do for dentro do método toString, que
    //as vezes pode ser mais legível.
    public String toString() {
// Verificando se a Lista está vazia
        if(this.totalDeElementos == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;
// Percorrendo até o penúltimo elemento.
        for (int i = 0; i < this.totalDeAlunos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
// último elemento
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }

}
