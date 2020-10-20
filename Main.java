import tools.prepare;
import tools.run;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run.quiz();
        long end = System.currentTimeMillis();
        System.out.println("total : " + (double)(end - start)/1000 + "s.");
    }
}
