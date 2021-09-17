import java.util.Random;

public class HashTable {
    private int colision = 0;
    private NodeTable[] table;

    public HashTable(int size) {
        table = new NodeTable[size];
        fillTable();
    }

    public void insert(int value) {
        NodeTable n = table[hash(value)];
        if(n.getInfo() == -1){
            n.setInfo(value);
        }else if(n.getInfo() != -1 && n.getList() == null){
            colision++;
            n.createList(value);
        }else{
            colision++;
            n.getList().insertOrdered(value);
        }
    }

    public int hash(int value) {
        return value % table.length;
    }

    public void fillTable(){
        for(int i = 0; i < table.length; i++){
            table[i] = new NodeTable();
        }
        Random r = new Random();
        for(int i = 0; i < table.length * 0.9; i++){
            int num = r.nextInt(1000001);
            insert(num);
        }
    }

    public void tableInfo(){
        for(int i = 0; i < table.length; i++){
            System.out.print(i + " " + table[i].getInfo());
            if(table[i].getList() != null){
                table[i].getList().printList();
            }
            System.out.println(" ");
        }
    }

    public boolean search(int value){
        int h = hash(value);
        if(table[h].getInfo() == value){
            return true;
        }else if(table[h].getList() != null){
            return table[h].getList().getNodeByInfo(value);
        }
     return false;
    }
}