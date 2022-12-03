//Aug/02

public class Main {

    public static void main(String[] args) {
//        long initialTime = System.nanoTime();
//
//        for(int i = 0; i <= 5_000_000; ++i)
//            System.out.print("X");
//
//        long endTime = System.nanoTime() - initialTime;
//        System.out.println("\n\n Time: " + endTime/1e9 + "s");


        //Aug 04
        //Cálculo do valor de PI Leibniz

        double pi = 0.0;
        double num = 1.0;

        long t0 = System.nanoTime();

        for(long i = 0; i < 5_000_000_000L; ++i){
            pi += num / (2 * i + 1);
            num = -num;
        }

        pi *= 4;
        long d = System.nanoTime() - t0;

        System.out.println("\nPI: " + pi);
        System.out.println("\n\n Time: " + d/1e9 + "s");
    }
}
