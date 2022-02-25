import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;


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
        }
    }

    //--------------------------------------------------------//
    //Создадим вывод информации за месяц
    public static void allStepsToMounth(int toMonthName) {
        int[] monthData = monthToData.get(toMonthName);
        int sumSteps = 0;
        int maxSteps = 0;
        double averageStep = 0;
        int notZeroSteps = 0;
        // создаём два значения для поиска лучшей серии
        int bestSeriesOne = 0; // нужен для вычисления текущей серии
        int bestSeriesTwo = 0; // нужен для сохранения максимальной серии
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < monthData.length; i++) {
            System.out.print((i + 1) + " день: " + monthData[i] + ", ");
            sumSteps += monthData[i];
            if (monthData[i] > maxSteps) maxSteps = monthData[i];
            if (monthData[i] > 0) notZeroSteps += 1;
            if (notZeroSteps != 0) averageStep = (sumSteps / notZeroSteps);
            /*
            если кол-во шагов в день = или больше цели, то начинаем сумировать bestSeriesOne и
            сравнивать его с bestSeriesTwo и если оно больше то bestSeriesTwo становиться = bestSeriesOne
            так мы сохраняем серию. как только кол-во шагов в день < цели, то скидываем bestSeriesOne.
            и так пока не пройдёт весь цикл.
             */
            if (monthData[i] >= targetSteps) {
                bestSeriesOne += 1;
                if (bestSeriesOne > bestSeriesTwo){
                    bestSeriesTwo = bestSeriesOne;
                }
            } else if (monthData[i] < targetSteps){
                bestSeriesOne = 0;
            }
        }
        System.out.println(" ");
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Среднее количество шагов в месяце: " + averageStep);
        Converter(sumSteps);
        System.out.println("Лучшая серия шагов в месяце: " + bestSeriesTwo);
    }

    //--------------------------------------------------------//
    //Создадим Конвертер
    public static void Converter(int step) {
        double stepToKM = step * 0.00075; // преобразовываем шаги в км при условии, что 1 шаг = 75 см = 0,75 м = 0,00075 км
        System.out.println("Пройденная дистанция (в км): " + stepToKM);
        double stepToKilocalories = step * 0.05; // преобразовываем шаги в килокалории при условии, что 1 шаг = 50 калорий
        System.out.println("Количество сожжённых килокалорий: " + stepToKilocalories);
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
        for (int i = 0; i < 12; i++) System.out.print((i + 1) + "-" + monthName[i] + ": ");
    }

    //Секретная функция для автоматического заполнения Хэш-таблицы, создана для тестов
    public static void autoComplete(){
        Random random = new Random();
        for (int i = 1; i <13; i++ ){
            int[] monthData = new int[30];
            for (int x = 0; x < monthData.length; x++) {
                monthData[x] = random.nextInt(20000);
            }
            monthToData.put(i, monthData);
        }
    }

}
