package tools;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Random;
import java.io.File;

public class prepare {
    public static String[] quiz(int num) {
        Random rand = new Random();
        String[] ret = new String[num];
        String file;
        int switchQuiz = 0;
        System.out.print("0...英単語/1...数字/2...かな : ");
        try {
            switchQuiz = run.stdIn.nextInt();
            if (switchQuiz > 2 || switchQuiz < 0) throw new Exception();
        } catch (Exception e) {
            System.out.println("デフォルトでは\"英単語\"を選択します。");
        }
        switch (switchQuiz) {
            case 1 : file = "numbers.txt"; break;
            case 2 : file = "kana.txt"; break;
            default : file = "words.txt";
        }
        try {
            LineNumberReader lr = new LineNumberReader(new FileReader("quiz/" + file));
            int count = 0;
            while (lr.readLine() != null) count++;
            lr.close();
            int[] randomNum = new int[num];
            for (int i = 0; i < num; i++) {
                LOOP : while (true) {
                    randomNum[i] = rand.nextInt(count) + 1;
                    if (i == 0) break;
                    for (int j = 0; j < i; j++) {
                        if (randomNum[j] == randomNum[i]) break;
                        if (j == i - 1) break LOOP;
                    }
                }
            }
            for (int i = 0; i < num; i++) {
                lr = new LineNumberReader(new FileReader("quiz/" + file));
                for (int j = 0; j < count; j++) {
                    ret[i] = lr.readLine();
                    if (randomNum[i] == lr.getLineNumber()) {
                        break;
                    }
                }
                lr.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }
}
