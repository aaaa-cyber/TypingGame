package tools;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class RankData {
    private boolean IsNewRecord = false;
    private ArrayList<Double> list;
    private final String PathToFile;
    private final double TimeOfThisTime;
    private int RankOfThisTime;

    RankData (String FileName, double TimeOfThisTime) {
        RankOfThisTime = 0;
        this.TimeOfThisTime = TimeOfThisTime;
        this.PathToFile = "ranking/" + FileName;
        list = prepare.readTextsDoubleList(PathToFile);
        AddToListInOrder(TimeOfThisTime);
        WriteRanking();
    }

    void AddToListInOrder(double value) {
        if (list.size() == 0) {
            list.add(value);
        } else {
            boolean IsLast = true;
            for (int i = 0; i < list.size(); i++) {
                RankOfThisTime = i + 1;
                if (list.get(i) > value) {
                    if (i < 3) IsNewRecord = true;
                    list.add(i, value);
                    IsLast = false;
                    break;
                }
            }
            if (IsLast) {
                list.add(value);
                RankOfThisTime = list.size();
            }
        }
    }

    void WriteRanking() {
        try {
            File file = new File(PathToFile);
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            for (int i = 0; i < list.size(); i++) {
                printWriter.println(list.get(i));
            }
            printWriter.close();
        } catch (Exception e) {
            System.out.println();
        }
    }
    public void ShowRanking() {
        String result = "------RESULT------";
        String bar = "------------------";
        System.out.println(result);
        for (int i = 1; i <= 3; i++) {
            try {
                System.out.print(i + ":" + list.get(i - 1) + "s");
                if (RankOfThisTime == i) System.out.print("  ←This time!");
                System.out.println();
            } catch (Exception IndexOutOfBoundsException) {
                //試行回数が３回未満の場合
                System.out.println(i + ":" + "null");
            }
        }
        if (IsNewRecord) System.out.println("N E W   R E C O R D  ! ! !");
        //ランク外
        if (RankOfThisTime > 3) {
            System.out.println("...");
            System.out.println(RankOfThisTime + ":" + TimeOfThisTime + "s  ←This time!");
        }
        System.out.println(bar);
    }
}
