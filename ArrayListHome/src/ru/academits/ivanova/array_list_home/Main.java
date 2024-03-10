package ru.academits.ivanova.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";

        try (FileReader fileReader = new FileReader(fileName)) {
            System.out.println("Все строки файла " + fileName + ":" + getFileLines(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 10, 7, 8, 4, 5, 7, 2, 7, 3, 7, 6, 4, 3, 10));

        System.out.println("Исходный список чисел: " + numbers);
        deleteEvenNumbers(numbers);
        System.out.println("Список после удаления из него всех четных чисел:  " + numbers);
        System.out.println("Новый список чисел на основе прежнего, но без повторений: " + createNotDuplicateDigitsList(numbers));
    }

    public static ArrayList<String> getFileLines(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    public static void deleteEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
    }

    public static ArrayList<Integer> createNotDuplicateDigitsList(ArrayList<Integer> numbers) {
        ArrayList<Integer> resultNotDuplicateDigitsList = new ArrayList<>(numbers.size());

        if (numbers.size() > 0) {
            for (Integer number : numbers) {
                if (!resultNotDuplicateDigitsList.contains(number)) {
                    resultNotDuplicateDigitsList.add(number);
                }
            }
        }

        return resultNotDuplicateDigitsList;
    }
}