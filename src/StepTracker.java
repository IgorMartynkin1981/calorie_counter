import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class StepTracker {
    static HashMap<Integer, int[]> monthToData = new HashMap<>();
    //так как число дней в месяце закреплено  и = 30, то используем массив

    static int targetSteps = 10000; // значение может изменяться из changeTargetSteps

    // создадим масив с именами месяцев, для вывода на печать и возможно ещё где понадобится
    static String[] monthName = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};


    //--------------------------------------------------------//
    //Создаём обработу добавления значения
    public static void StepTracker(int toMonthName, int toMonthData, int toSteps) {

        if (!monthToData.containsKey(toMonthName)){ //if not found value
            int[] monthData = new int[30];
            monthData[(toMonthData - 1)] = toSteps;
            monthToData.put(toMonthName, monthData);
        } else {                                    //if found value
            int[] monthData = monthToData.get(toMonthName);
            monthData[(toMonthData - 1)] = toSteps;
            //monthToData.put(toMonthName, monthData);

        }
    }

    //--------------------------------------------------------//
    //Печать всей ХЭШ-таблицы. Для контроля при написании
    static void printAllmonthToData() {
        for (int category : monthToData.keySet()) {
            int[] monthData = monthToData.get(category);
            for (int i = 0; i < monthData.length; i++) {
                System.out.println("Month: " + monthName[category-1] + " Day: " + (i+1) + " Step = " + monthData[i]);
            }
        }
    }

    //--------------------------------------------------------//
    /* changeTargetSteps присваивает новое значение цели по количеству шагов в день
    значение newTargetStep прилетает из calorie_counter
     */
    static void changeTargetSteps(int newTargetStep){
        targetSteps = newTargetStep;
        System.out.println(targetSteps);
    }

    //для отображения месяцев при запросе о вводе и выводе
    static void printMonth(){
        /*
        for (int i = 0; i < 12; i++) {
            System.out.println((i+1) + "-" + monthName[i]);
        }
        */
        for (int i = 0; i < 12; i++) {
            System.out.print((i+1) + "-" + monthName[i] + ": ");
        }
    }

}
