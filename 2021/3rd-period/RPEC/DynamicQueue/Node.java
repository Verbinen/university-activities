public class Node {
    private Integer info;
    private Node next;

    public Node(){
        info = null;
        next = null;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getInfo() {
        return info;
    }

    public Node getNext() {
        return next;
    }
}