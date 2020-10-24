package tools;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class rank {
    /**
     * 受け取った時間をランキングのリストに入れ、
     * そのランキングリストをtxtに書き込んだ後、
     * そのランキングリストを返却する。
     *
     * @param pathToFile
     * @param time
     */
    public static ArrayList<Double> addTime(String pathToFile, double time) {
        ArrayList<Double> list = prepare.readTextsDoubleList(pathToFile);
        if (list.size() == 0) {
            list.add(time);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > time) {
                    list.add(i, time);
                    break;
                }
            }
        }
        try {
            File file = new File(pathToFile);
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            for (int i = 0; i < list.size(); i++) {
                printWriter.println(list.get(i));
            }
            printWriter.close();
        } catch (Exception e) {
            System.out.println();
        }
        return list;
    }

    public static void ing(double time) {
        String pathToRanking = "ranking/" + prepare.file;
        ArrayList<Double> ranking = addTime(pathToRanking, time);
        String bar = "-------------------";
        System.out.println(bar);
        boolean isNewRecord = false;
        for (int i = 1; i <= 3; i++) {
            try {
                System.out.println(i + ":" + ranking.get(i - 1) + "s");
                if (ranking.get(i - 1) == time) isNewRecord = true;
            } catch (Exception IndexOutOfBoundsException) {
                //試行回数が３回未満の場合
                System.out.println(i + ":" + "null");
            }
        }
        if (isNewRecord) System.out.println("N E W   R E C O R D  ! ! !");
        System.out.println(bar);
    }
}
