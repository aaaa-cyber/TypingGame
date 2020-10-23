package tools;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            BufferedReader lr = new BufferedReader(new FileReader("quiz/" + file));
            List<String> list = new ArrayList<String>();
            while (lr.readLine() != null) list.add(lr.readLine());
            lr.close();
            int[] randomNum = new int[num];
            //乱数の生成
            for (int i = 0; i < num; i++) {
                LOOP : while (true) {
                    randomNum[i] = rand.nextInt(list.size()) + 1;
                    //重複チェック
                    if (i == 0) break;
                    for (int j = 0; j < i; j++) {
                        if (randomNum[j] == randomNum[i]) break;
                        if (j == i - 1) break LOOP;
                    }
                }
                ret[i] = list.get(randomNum[i]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }
}
