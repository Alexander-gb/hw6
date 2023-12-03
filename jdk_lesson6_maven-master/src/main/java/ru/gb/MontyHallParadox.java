package ru.gb;
//hw6
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        int totalTests = 1000; // Общее количество испытаний
        int switchWins = 0; // Количество побед при смене выбора
        int stayWins = 0; // Количество побед без смены выбора

        Random random = new Random();

        for (int i = 1; i <= totalTests; i++) {
            int carPosition = random.nextInt(3); // Позиция автомобиля (0, 1 или 2)
            int initialChoice = random.nextInt(3); // Первоначальный выбор игрока

            // Определение двери, которая будет открыта ведущим ведущим
            int doorToOpen;
            do {
                doorToOpen = random.nextInt(3);
            } while (doorToOpen == carPosition || doorToOpen == initialChoice);

            // Игрок меняет выбор
            int finalChoice;
            do {
                finalChoice = random.nextInt(3);
            } while (finalChoice == initialChoice || finalChoice == doorToOpen);

            // Проверка победы при смене выбора
            if (finalChoice == carPosition) {
                switchWins++;
            }

            // Проверка победы без смены выбора
            if (initialChoice == carPosition) {
                stayWins++;
            }
        }

        // Сохраняем результаты в HashMap
        Map<String, Integer> results = new HashMap<>();
        results.put("С победой при смене выбора", switchWins);
        results.put("С победой без смены выбора", stayWins);

        // Выводим статистику
        System.out.println("Статистика побед и поражений:");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            String strategy = entry.getKey();
            int wins = entry.getValue();
            int losses = totalTests - wins;
            System.out.println(strategy + ": " + wins + " побед, " + losses + " поражений");
        }
    }
}