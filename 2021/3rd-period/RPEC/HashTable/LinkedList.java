public class LinkedList {
    private Node first;
    private Node currentNode;
    private Node currentNode2;
    private boolean isOrdered;

    public LinkedList(int value){
        insertOrdered(value);
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
            System.out.print("A lista está vazia \n");
        }
        else if (currentNode.getNext() != null){
            currentNode = currentNode.getNext();
            setCurrentToLast();
        }
    }

    public boolean getNodeByInfo(int info) {
        if (isEmpty()) {
            return false;
        }
        else if (currentNode.getInfo() == info) {
            return true;
        }

        else if (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            return getNodeByInfo(info);
        }
        else {
            return false;
        }

    }

    public void printList(){
        if(isEmpty()){
            System.out.print("A lista está vazia");
            return;
        }
        System.out.print("  " + currentNode.getInfo());
        if(currentNode.getNext() != null){
            //System.out.println("-------");
            currentNode = currentNode.getNext();
            printList();
        }
        else{
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
            //System.out.println("A lista não está ordenada");
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
}