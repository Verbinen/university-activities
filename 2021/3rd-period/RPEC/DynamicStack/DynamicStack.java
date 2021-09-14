public class DynamicStack {
    private Node last;

    public DynamicStack(){
        last = null;
    }

    public boolean isEmpty(){
        if(last == null)
            return true;
        return false;
    }

    public void insertLast(int info){
        if(isEmpty()){
            last = new Node();
            last.setInfo(info);
            return;
        }
        Node n1 = new Node();
        n1.setInfo(info);
        n1.setNext(last);
        last = n1;
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("A pilha está vazia");
            return;
        }

        Node n1 = last;
        while(true){
            System.out.println("Info: " + n1.getInfo());
            if(n1.getNext() != null){
                System.out.println("-------");
                n1 = n1.getNext();
            }
            else{
                return;
            }
        }
    }

    public void removeLast(){
        if(isEmpty()){
            System.out.println("A pilha está vazia");
            return;
        }
        last = last.getNext();
    }

    public int getLast() throws NullPointerException{
        return last.getInfo();
    }
}