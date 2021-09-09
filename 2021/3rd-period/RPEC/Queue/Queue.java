public class Queue{
    private int first;
    private int last;
    private int[] data;

    public boolean isFull(){
        if(first == 0 & last == data.length -1 || first -1 == last)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if(first == -1 && last == -1)
            return true;
        return false;
    }

    public void remove() {
        if(!isEmpty()){
            if(first == last){
                first = -1;
                last = -1;
            }
            else if(first == data.length -1)
                first = 0;
            else
                first++;
        }
        else
            System.out.println("A fila está vazia");
    }

    public void insert(int value){
        if(!isFull() && !isEmpty()) {
            if (last == data.length - 1) {
                last = 0;
                data[last] = value;
            } else {
                last++;
                data[last] = value;
            }
        }
        else if(isEmpty()){
            first++;
            last++;
            data[last] = value;
        }
        else
            System.out.println("A fila está cheia");
    }

    public void print(){
        if (first < last){
            for(int i = first; i <= last; i++){
                System.out.println(i +" - " +data[i]);
            }
        }
        else if(first > last){
            for(int i = first; i <= data.length -1; i++){
                System.out.println(i +" - " +data[i]);
            }
            for(int i = 0; i <= last; i++){
                System.out.println(i +" - " +data[i]);
            }
        }
        else if(first == last && last != -1)
            System.out.println(first +" - " +data[last]);
        else
            System.out.println("\nA fila está vazia\n");
    }

    public int getQueueLenth(){
        return data.length;
    }

    public int getFirst(){
        return data[first];
    }

    public Queue(int value){
        this.data = new int[value];
        this.first = -1;
        this.last = -1;
    }
}
