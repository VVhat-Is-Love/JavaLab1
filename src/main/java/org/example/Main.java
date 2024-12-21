package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Nutritious> breakfast = new ArrayList<>();

        System.out.println("Доступные начинки: вишнёвая, клубничная, яблочная");
        System.out.print("Введите количество пирогов: ");
        int pieCount = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        for (int i = 0; i < pieCount; i++) {
            System.out.println("Введите данные для пирога #" + (i + 1));

            while (true) {
                System.out.print("Начинка: ");
                String filling = scanner.nextLine();

                try {
                    breakfast.add(new Pie(filling));
                    break; // Выход из цикла, если начинка валидна
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Попробуйте ещё раз.");
                }
            }
        }

        // Добавляем яблоко
        breakfast.add(new Apple());

        // Подсчет общей калорийности
        int totalCalories = breakfast.stream()
                .mapToInt(Nutritious::calculateCalories)
                .sum();
        System.out.println("\nОбщая калорийность завтрака: " + totalCalories + " ккал");

        // Сортировка (если применимо)
        breakfast.sort((o1, o2) -> Integer.compare(o1.calculateCalories(), o2.calculateCalories()));

        // Вывод содержимого списка
        System.out.println("\nСостав завтрака:");
        breakfast.forEach(System.out::println);

        scanner.close();
    }
}
