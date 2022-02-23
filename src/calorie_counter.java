import java.util.Scanner;

public class calorie_counter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int targetSteps = 10000;

        while (true) {
            printMenu(); //реализовываем печать меню
            int command = scanner.nextInt(); // повторное считывание данных от пользователя
            if (command == 1) {
                System.out.println("Command 1");
            } else if (command == 2) {
                System.out.println("Command 2");
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
