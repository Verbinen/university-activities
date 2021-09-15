public class Queue {
    private DynamicQueue list;

    public Queue(){
        list = new DynamicQueue();
    }

    public void insertInQueue(int data){
        list.insertLast(data);
    }

    public void showQueue(){
        list.printQueue();
    }

    public void removeFromQueue(){
        list.removeFirst();
    }
}