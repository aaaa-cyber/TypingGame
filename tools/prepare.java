package tools;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.File;

public class prepare {
    public static String file;

    public static ArrayList<String> readTextsStringList(String filePass) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader lr = new BufferedReader(new FileReader(new File(filePass)));
            String temp;
            while ((temp = lr.readLine()) != null) list.add(temp);
            lr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static ArrayList<Double> readTextsDoubleList(String filePass) {
        ArrayList<Double> list = new ArrayList<>();
        try {
            BufferedReader lr = new BufferedReader(new FileReader(filePass));
            String temp;
            while ((temp = lr.readLine()) != null) list.add(Double.parseDouble(temp));
            lr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static ArrayList<String> quizList() {
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
        return readTextsStringList("quiz/" + file);
    }
}
