public class ValidadorExpressao {
    private int topo;
    private String dados[];
    private int max;

    public ValidadorExpressao(int n){
        this.max = n;
        this.topo = -1;
        this.dados = new String[n];
    }

    public String returnTopo(){
        if (isVazia())
            return "Pilha vazia";
        return dados[topo];
    }

    public boolean isVazia(){
        if(topo == -1)
            return true;
        return false;
    }

    public boolean isCheia(){
        if(topo == max - 1)
            return true;
        return false;
    }

    public void empilhar(String caracter){
        if(!isCheia()){
            topo++;
            dados[topo] = caracter;
        }
        else
            System.out.println("A pilha está cheia");
    }

    public void desempilhar(){
        if(!isVazia()){
            topo--;
        }
        else
            System.out.println("A pilha está vazia");
    }

    public void validarExpressao(String expressao){

        for(int i = 0; i < expressao.length(); i++) {
            if (expressao.charAt(i) == '(')
                empilhar("(");
            if (expressao.charAt(i) == '{')
                empilhar("{");
            if (expressao.charAt(i) == '[')
                empilhar("[");
            if (expressao.charAt(i) == ')' && topo == -1 || expressao.charAt(i) == ')' && returnTopo() != "("){
                System.out.println("Expressão inválida");
                return;
            }
            if (expressao.charAt(i) == '}' && topo == -1 || expressao.charAt(i) == '}' && returnTopo() != "{"){
                System.out.println("Expressão inválida");
                return;
            }
            if (expressao.charAt(i) == ']' && topo == -1 || expressao.charAt(i) == ']' && returnTopo() != "["){
                System.out.println("Expressão inválida");
                return;
            }
            if (expressao.charAt(i) == ')' && returnTopo().equals("("))
                desempilhar();
            if (expressao.charAt(i) == '}' & returnTopo().equals("{"))
                desempilhar();
            if (expressao.charAt(i) == ']' & returnTopo().equals("["))
                desempilhar();
        }
    System.out.println("Expressão Válida");
    }
}