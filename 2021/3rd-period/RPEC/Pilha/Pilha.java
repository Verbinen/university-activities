public class Pilha {
    private int topo;
    private int dados[];

    public String returnTopo(){
        if (!isVazia())
            return Integer.toString(dados[topo]);
        return "A pilha está vazia";
    }

    public Integer returnTopo2(){
        if (!isVazia())
            return dados[topo];
        return null;
    }

    public boolean isVazia(){
        if (topo == -1)
            return true;
        return false;
    }

    public boolean isCheia(){
        if (topo == dados.length-1)
            return true;
        return false;
    }

    public void empilhar(int elemento){
        if(!isCheia()){
            topo ++;
            dados[topo] = elemento;
            System.out.println("Empilhamento bem sucedido");
        }
        else
            System.out.println("A pilha já está cheia");
    }

    public String desempilhar(){
        if (!isVazia()){
            topo --;
            return Integer.toString(dados[topo+1]);
        }
        else
            return "A pilha já está vazia";
    }

    public void criarPilha(int n){
        dados = new int[n];
        topo = -1;
    }
}