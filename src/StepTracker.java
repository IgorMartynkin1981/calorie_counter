import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    static int targetSteps = 10000;

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
}
