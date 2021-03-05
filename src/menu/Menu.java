package menu;


import treasures.TreasureList;

import java.util.Scanner;

public class Menu {

    private static void showMenu() {
        System.out.println("-------------------------");
        System.out.println("1.Просмотреть сокровища");
        System.out.println("2.Выбрать самое дорогое сокровище");
        System.out.println("3.Выбрать сокровища на заданную сумму");
        System.out.println("4.Выход");
        System.out.println("-------------------------");
    }

    public static void start() {
        TreasureList list = new TreasureList("src/treasures.txt");
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        do {
            Menu.showMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    list.showList();
                    break;
                case 2:
                    System.out.println("Самое дорогое сокровище:\n" + list.getByMaxCost());
                    break;
                case 3:
                    list.getBySum();
                    break;
                case 4:
                    flag = true;
                    break;
                default:
                    System.out.println("Некорректный выбор");
                    break;
            }
        } while (!flag);

        sc.close();
    }
}
