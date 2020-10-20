package tools;

import java.util.Scanner;

public class run {
    public static Scanner stdIn = new Scanner(System.in);
    public static void quiz() {
        int howMany = 3;
        String[] question = prepare.quiz(howMany);
        for (int i = 0; i < howMany; i++) {
            while (true) {
                System.out.println(question[i]);
                if (stdIn.next().equals(question[i])) break;
            }
        }
    }
}
