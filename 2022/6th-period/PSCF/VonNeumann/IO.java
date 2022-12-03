public class IO {
    private CPU cpu;

    public IO(String msg){
        output(msg);
    }

    public void output(String msg){
        System.out.println("\n\n" + msg);
    }
}
