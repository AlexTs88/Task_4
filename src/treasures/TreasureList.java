package treasures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TreasureList {
    String fileName;
    Treasure[] treasures;

    public TreasureList(String fileName){
        this.fileName = fileName;
        read();
    }

    private void read() {
        Treasure[] _treasures = new Treasure[100];
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int index = 0;
        if (sc != null) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split(" ");

                switch (values[0].toLowerCase()) {
                    case "coin":
                        _treasures[index] = new Coin(index + 1, values[0], Material.valueOf(values[1].toUpperCase()), Size.valueOf(values[2].toUpperCase()));
                        break;
                    case "ring":
                        _treasures[index] = new Ring(index + 1, values[0], Material.valueOf(values[1].toUpperCase()), Size.valueOf(values[2].toUpperCase()));
                        break;
                    case "stone":
                        _treasures[index] = new Stone(index + 1, values[0], Material.valueOf(values[1].toUpperCase()), Size.valueOf(values[2].toUpperCase()));
                        break;
                }
                index ++;
            }
            sc.close();
        }
        treasures = Arrays.copyOfRange(_treasures, 0, 100);
    }

    public void showList() {
        for (Treasure treasure : treasures) {
            System.out.println(treasure);
        }
    }

    public Treasure getByMaxCost() {
        double maxCost = 0;
        Treasure treasure = null;

        for (Treasure element : treasures) {
            if (maxCost < element.getCost()) {
                maxCost = element.getCost();
                treasure = element;
            }
        }
        return treasure;
    }

    public void getBySum() {
        ArrayList<Treasure> selectedTreasures = new ArrayList<>();
        double minCost = treasures[0].getCost();
        for (Treasure treasure : treasures) {
            if (minCost > treasure.getCost()) minCost = treasure.getCost();
        }
        System.out.println("Введите сумму:");
        Scanner sc = new Scanner(System.in);
        double sum = sc.nextDouble();
        do {
            System.out.println("Возможный выбор:");
            for (Treasure treasure : treasures) {
                if (treasure.getCost() <= sum) {
                    System.out.println(treasure);
                }
            }

            if (selectedTreasures.size() > 0) {
                System.out.println("Выбранные сокровища:");
                for (Treasure treasure : selectedTreasures) {
                    System.out.println(treasure);
                }
            }
            System.out.print("Остаток: " + sum + "\n");

            System.out.println("Выберите сокровище по номеру:");
            int number = sc.nextInt();
            if (number > 0 && number <= 100 && sum >= treasures[number - 1].getCost()) {
                selectedTreasures.add(treasures[number - 1]);
                sum -= treasures[number - 1].getCost();
            } else {
                System.out.println("Неправильный номер!");
            }
        } while (sum >= minCost);

        System.out.println("Выбранные сокровища:");
        for (Treasure treasure : selectedTreasures) {
            System.out.println(treasure);
        }
    }
}
