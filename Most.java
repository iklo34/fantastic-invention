package com.example.jore;
import java.util.HashMap;
import java.util.Map;

public class Most {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2, 3, 2, 5, 6, 1, 6, 6, 6};

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        System.out.println("Найчастіше зустрічаються числа:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                System.out.println(entry.getKey());
            }
        }
    }
}

