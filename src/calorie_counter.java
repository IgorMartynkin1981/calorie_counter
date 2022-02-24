import java.util.Scanner;

public class calorie_counter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu(); //реализовываем печать меню
            int command = scanner.nextInt(); // повторное считывание данных от пользователя
            //Ввести количество шагов за определённый день
            if (command == 1) {
                System.out.println("Вы хотите ввести данные о пройденных шагах:");
                StepTracker.printMonth();
                System.out.println("");
                int monthData;
                int monthName;
                while (true) {
                    System.out.print("Введите месяц: ");
                    int toMonthName = scanner.nextInt();
                    if ((toMonthName < 1) || (toMonthName > 12)) {
                        System.out.println("Число должно быть в диапозоне от 1 до 12");
                    } else {
                        monthName = toMonthName;
                        break;
                    }
                }
                while (true) {
                    System.out.print("Введите число месяца (от 1 до 30): ");
                    int toMonthData = scanner.nextInt();
                    if ((toMonthData < 1) || (toMonthData > 30)) {
                        System.out.println("Число должно быть в диапозоне от 1 до 30");
                    } else {
                        monthData = toMonthData;
                        break;
                    }
                }
                System.out.print("Введите количество пройденных шагов: ");
                int toSteps = scanner.nextInt();
                StepTracker.StepTracker(monthName, monthData, toSteps);
                System.out.println("Информация сохранена!");

            //Напечатать статистику за определённый месяц
            } else if (command == 2) {
                System.out.println("Command 2");

            //Изменить цель по количеству шагов в день
            } else if (command == 3) {
                System.out.println("Введите новую цель по количеству шагов в день");
                int newTargetSteps = scanner.nextInt();
                    if (newTargetSteps > 0) {
                        StepTracker.changeTargetSteps(newTargetSteps);
                    } else {
                        System.out.println("Значение должно быть больше 0");
                    }
            } else if (command == 0) {
                System.out.println("Command 0");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }


    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
