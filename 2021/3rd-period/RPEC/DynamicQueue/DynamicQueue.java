public class DynamicQueue {
    private Node first;
    private Node last;

    public DynamicQueue(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        if(first == null)
            return true;
        return false;
    }

    public void insertLast(int info){
        if(isEmpty()){
            first = new Node();
            first.setInfo(info);
            last = first;
            return;
        }
        if(first == last){
            last = new Node();
            last.setInfo(info);
            last.setNext(first);
            first.setNext(last);
        }

        else{
            Node n1 = new Node();
            n1.setInfo(info);
            n1.setNext(first);
            last.setNext(n1);
            last = n1;
        }
    }

    public void printQueue(){

        if(isEmpty()){
            System.out.print("A fila está vazia");
            return;
        }
        if(first.getNext() == null){
            System.out.println("Info: " + first.getInfo());
            return;
        }
        if(first.getNext() == last){
            System.out.println("Info: " + first.getInfo() + "\n -------\nInfo: " + last.getInfo() );
            return;
        }
        Node n1 = first;
        while(true){
            System.out.println("Info: " + n1.getInfo());
            if(n1.getNext() != first){
                System.out.println("-------");
                n1 = n1.getNext();
            }
            else{
                return;
            }
        }
    }

    public void removeFirst(){
        if(isEmpty()){
            System.out.println("Sem itens");
        }
        else if(first.getNext() == last){
            last.setNext(null);
            System.out.println("Valor retirado: " + first.getInfo());
            first = last;

        }
        else{
            last.setNext(first.getNext());
            System.out.println("Valor retirado: " + first.getInfo());
            first = first.getNext();
        }
    }
}