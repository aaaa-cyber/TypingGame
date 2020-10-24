package tools;

import java.util.ArrayList;
import java.io.FileWriter;

public class rank {
    public static double[] AryListToDouble(ArrayList<String> aryList) {
        double[] list = new double[aryList.size()];
        for (int i = 0; i < aryList.size(); i++) {
            list[i] = Double.parseDouble(aryList.get(i));
        }
        return list;
    }

    //出力した値はリストから削除されます。
    public static double minOfTheList(ArrayList<String> aryList) {
        double[] list = AryListToDouble(aryList);
        int index = 0;
        double min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
                index = i;
            }
        }
        aryList.remove(index);
        return min;
    }

    public static void addTime(double time, String file) {
        try {
            FileWriter ln = new FileWriter(file, true);
            ln.write("\n" + String.valueOf(time));
            ln.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void ing(double time) {
        String pathToRanking = "ranking/" + prepare.file;
        addTime(time, pathToRanking);
        ArrayList<String> ranking = prepare.textToAryList(pathToRanking);
        String bar = "-------------------";
        System.out.println(bar);
        boolean isNewRecord = false;
        for (int i = 1; i <= 3; i++) {
            double min = minOfTheList(ranking);
            System.out.println(i + ":" + min + "s");
            if (min == time) isNewRecord = true;
        }
        if (isNewRecord) System.out.println("N E W   R E C O R D  ! ! !");
        System.out.println(bar);
    }
}
