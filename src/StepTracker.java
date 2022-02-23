import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    static int targetSteps = 10000;
    static String[] monthName = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    class MonthData {
        // Заполните класс самостоятельно
    }

    static void changeTargetSteps(int newTargetStep){
        targetSteps = newTargetStep;
        System.out.println(targetSteps);
    }

    static void printMonth(){
        for (int i = 0; i < 12; i++) {
            System.out.println((i+1) + "-" + monthName[i]);
        }
    }

}
