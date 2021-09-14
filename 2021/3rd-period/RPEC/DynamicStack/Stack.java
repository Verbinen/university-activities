public class Stack{
    private DynamicStack list;

    public Stack(){
        list = new DynamicStack();
    }

    public void insertStack(int data){
        list.insertLast(data);
    }

    public void removeStack(){
        list.removeLast();
    }

    public int returnTop(){
        return list.getLast();
    }

    public void showStack(){
        list.printStack();
    }
}
