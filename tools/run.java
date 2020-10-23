package tools;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class run {
    public static Scanner stdIn = new Scanner(System.in);
    public static void quiz() {
        Random rand = new Random();
        int howMany = 3;
        ArrayList<String> list = prepare.quizList();
        for (int i = 0; i < howMany; i++) {
            int randomNum = rand.nextInt(list.size());
            while (true) {
                System.out.println(list.get(randomNum));
                if (stdIn.next().equals(list.get(randomNum))) {
                    list.remove(randomNum);
                    break;
                }
            }
        }
    }
}
