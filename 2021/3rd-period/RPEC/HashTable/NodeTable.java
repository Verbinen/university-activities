public class NodeTable {
    private Integer info;
    private LinkedList list;

    public NodeTable(){
        this.info = -1;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public LinkedList getList() {
        return list;
    }

    public void createList(int value) {
        this.list = new LinkedList(value);
    }
}
