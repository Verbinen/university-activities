public class LinkedList {
    private Node first;
    private Node currentNode;
    private Node currentNode2;
    private boolean isOrdered;

    public LinkedList(){
        first = null;
    }

    public boolean isEmpty(){
        if(first == null)
            return true;
        return false;
    }

    public void insertFirst(int info){
        if(isEmpty()){
            Node n1 = new Node();
            n1.setInfo(info);
            first = n1;
            currentNode = first;
            currentNode2 = first;
        }
        else{
            Node n1 = new Node();
            n1.setInfo(info);
            n1.setNext(first);
            first = n1;
            currentNode = first;
            currentNode2 = first;
        }
    }

    public void insertLast(int info){
        if(isEmpty()){
            insertFirst(info);
            return;
        }
        setCurrentToLast();
        Node n1 = new Node();
        n1.setInfo(info);
        currentNode.setNext(n1);
        currentNode = first;
    }

    public void insertAfter(int info, int infoToInsert){
        getNodeByInfo(info); // current.getInfo = info

        if(getNodeByInfo(info)){
            Node n1 = new Node();
            n1.setInfo(infoToInsert);
            n1.setNext(currentNode.getNext());
            currentNode.setNext(n1);
            currentNode = first;
        }

    }

    public void setCurrentToLast(){

        if(isEmpty()) {
            System.out.print("A lista está vazia");
        }

        else if (currentNode.getNext() != null){
            currentNode = currentNode.getNext();
            setCurrentToLast();
        }
    }

    public boolean getNodeByInfo(int info) {
        if (isEmpty()) {
            System.out.print("A lista está vazia");
            return false;
        }
        else if (currentNode.getInfo() == info) {
            return true;
        }

        else if (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            getNodeByInfo(info);
            return true;
        }

        else {
            System.out.print("Referência de valor não encontrada");
            return false;
        }
    }

    public void printList(){
        if(isEmpty()){
            System.out.print("A lista está vazia");
            return;
        }
        System.out.println("Info: " + currentNode.getInfo());
        if(currentNode.getNext() != null){
            System.out.println("-------");
            currentNode = currentNode.getNext();
            printList();
        }
        else{
            System.out.println("Next: Null\n\n");
            currentNode = first;
        }
    }

    public void insertOrdered(int info){

        //Se a lista estiver vazia adiciona como primeiro elemento
        if(isEmpty()){
            insertFirst(info);
            return;
        }


        checkOrder(); //Seta o atributo isOrdered para true ou false
        //Se tiver desordenada não adiciona
        if(!isOrdered){
            System.out.println("A lista não está ordenada");
            return;
        }

        else {
            //Verifica se o primeiro é maior que o valor que deseja adicionar
            if(first.getInfo() > info){
                insertFirst(info);
                currentNode = first;
                return;
            }

            //Verifica se existe um próximo
            if (currentNode.getNext() != null){

                //Verifica se info está entre o próximo e o atual
                if (currentNode.getNext().getInfo() > info && currentNode.getInfo() < info) {

                    //Insere logo após o atual
                    insertAfter(currentNode.getInfo(), info);
                    currentNode = first;
                    return;
                }

                //Caso exista próximo e não entrou no if acima, chama a função novamente
                else{
                    currentNode = currentNode.getNext();
                    insertOrdered(info);
                }
            }

            //Se não existir um próximo, adiciona no final
            else{
                currentNode = first;
                insertLast(info);
            }
        }


    }

    public void checkOrder() {
        //(2,3,4,5,1)
        if (currentNode2.getNext() != null) {
            if (currentNode2.getNext().getInfo() > currentNode2.getInfo()) {
                currentNode2 = currentNode2.getNext();
                checkOrder();
            }
            else {
                currentNode2 = first;
                isOrdered = false;
            }
        }

        else{
            currentNode2 = first;
            isOrdered = true;
        }
    }

    public void removeFirst(){
        if(isEmpty()){
            System.out.print("Lista vazia");
        }

        if(currentNode.getNext() == null){
            this.first = null;
            this.currentNode = null;
            return;
        }

        System.out.println("Informação retirada: " + currentNode.getInfo());
        first = currentNode.getNext();
        currentNode = first;
    }

    public void removeLast(){
        if(isEmpty()){
            System.out.println("Lista está vazia");
            return;
        }

        //Caso só exista um elemento na lista
        if(currentNode.getNext() == null) {
            System.out.println("Informação removida: " + currentNode.getInfo());
            removeFirst();
            return;
        }

        //Caso exista dois elementos na lista
        else if(currentNode.getNext().getNext() == null){
            System.out.println("Informação removida: " + currentNode.getNext().getInfo());
            currentNode.setNext(null);
            return;

        }

        //Caso exista mais de dois elementos na lista
        else if(currentNode.getNext().getNext().getNext() == null){
            System.out.println("Informação removida: " + currentNode.getNext().getNext().getInfo());
            currentNode.getNext().setNext(null);
            return;
        }
        else{
            currentNode = currentNode.getNext();
            removeLast();
        }

    }

    public void remove(int info) {

        //Caso esteja vazio
        if (isEmpty()) {
            System.out.println("Lista está vazia ");
            return;
        }

        //Caso seja o primeiro
        if (first.getInfo() == info) {
            System.out.println("Informação retirada: " + info);
            removeFirst();
            return;
        }

        //Caso não seja o primeiro

        //Verifica se existe um próximo
        if (currentNode.getNext() != null) {

            if (currentNode.getNext().getInfo() == info) {

                //Verifica se depois dele tem algo
                if (currentNode.getNext().getNext() == null) {
                    System.out.println("Informação retirada: " + info);
                    currentNode.setNext(null);

                    currentNode = first;
                    return;
                }

                else {
                    Node n1 = new Node();
                    n1 = currentNode.getNext(); // n1 = b
                    currentNode.setNext(currentNode.getNext().getNext());
                    n1.setNext(null);

                    currentNode = first;
                    return;
                }
            }

            //Se não encontrou a info que queremos
            else{
                currentNode = currentNode.getNext();
                remove(info);
            }

        }
        //Não existe um próximo e não encontrou o valor
        else{
            System.out.println("Não existe a informação que deseja remover");
            currentNode = first;
            return;
        }
    }

}