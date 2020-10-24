import tools.run;
import tools.rank;

class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        run.quiz();
        long end = System.currentTimeMillis();
        double time = (double)(end - start)/1000;
        System.out.println("total : " + time + "s.");
        rank.ing(time);
    }
}
