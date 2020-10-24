package tools;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class run extends prepare{
    public static Scanner stdIn = new Scanner(System.in);

    public static void quiz() {
        Random rand = new Random();
        int howManyQuizzes = 3;
        ArrayList<String> list = quizList();
        for (int i = 0; i < howManyQuizzes; i++) {
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

    public static void Result(double TimeOfThisTime) {
        RankData rank = new RankData(FileName, TimeOfThisTime);
        rank.ShowRanking();
    }
}
