public class Main {
    public static void main(String[] args) {

       // ***********PIlHA******
        Pilha p = new Pilha();
        p.criarPilha(5);

        System.out.println(p.isVazia());
        System.out.println(p.desempilhar());
        System.out.println(p.returnTopo());

        p.empilhar(5);
        System.out.println("O valor do topo é: " + p.returnTopo());

        p.empilhar(7);
        System.out.println("O valor do topo é: " + p.returnTopo());

        p.empilhar(9);
        System.out.println("O valor do topo é: " + p.returnTopo());

        p.empilhar(11);
        System.out.println("O valor do topo é: " + p.returnTopo());

        p.empilhar(13);
        System.out.println("O valor do topo é: " + p.returnTopo());

        System.out.println(p.isCheia());
        p.empilhar(15);

        System.out.println("O valor do topo era: " + p.desempilhar());
        System.out.println("O valor do topo era: " + p.desempilhar());
        System.out.println("O valor do topo era: " + p.desempilhar());
        System.out.println("O valor do topo era: " + p.desempilhar());
        System.out.println("O valor do topo era: " + p.desempilhar());
        System.out.println("O valor do topo era: " + p.desempilhar());



        /* ****** VALIDADOR DE EXPRESSÃO*********

        p.validarExpressao("(1+5)*(56+12)");

        p.validarExpressao("(1+5)*)56+12)");

        p.validarExpressao("(1+5)*[56+12)");

        p.validarExpressao("(((1+2)-3)*6)");

        */
    }
}
