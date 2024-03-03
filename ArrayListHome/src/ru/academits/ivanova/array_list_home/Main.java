package ru.academits.ivanova.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFileLines(new File("input.txt")));

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 10, 7, 8, 4, 5, 7, 2, 7, 3, 7, 6, 4, 3, 10));

        System.out.println(deleteEvenNumbers(numbers));
        System.out.println(deleteNumbersDuplicates(numbers));
    }

    public static ArrayList<String> getFileLines(File file) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }

        return lines;
    }

    public static ArrayList<Integer> deleteEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }

        return numbers;
    }

    public static ArrayList<Integer> deleteNumbersDuplicates(ArrayList<Integer> numbers) {
        ArrayList<Integer> resultNumbersList = new ArrayList<>(numbers.size());
        resultNumbersList.add(numbers.get(0));

        for (int i = 1; i < numbers.size(); i++) {
            if (!resultNumbersList.contains(numbers.get(i))) {
                resultNumbersList.add(numbers.get(i));
            }
        }

        return resultNumbersList;
    }
}