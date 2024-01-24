package com.example.jore;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberListProcessor {
    private List<Integer> numbers;

    public NumberListProcessor() {
        this.numbers = new ArrayList<>();
    }

    public void inputNumbersFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть числа у список (для завершення введення введіть нечисловий рядок):");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            numbers.add(number);
        }
    }

    public void processNumbersWithStreamAPI() {
        // a.
        int sumOfEvenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сума парних чисел: " + sumOfEvenNumbers);

        // b.
        List<Integer> multipliedNumbers = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        System.out.println("Список чисел, помножених на 2: " + multipliedNumbers);

        // c.
        int maxNumber = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println("Максимальне число: " + maxNumber);

        // d.
        String oddNumbersString = numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Непарні числа: " + oddNumbersString);

        // e.
        double average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow();
        System.out.println("Середнє арифметичне: " + average);
    }

    public static void main(String[] args) {
        NumberListProcessor processor = new NumberListProcessor();
        processor.inputNumbersFromConsole();
        processor.processNumbersWithStreamAPI();
    }
}
