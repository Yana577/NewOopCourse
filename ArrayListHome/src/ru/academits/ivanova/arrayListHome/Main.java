package ru.academits.ivanova.arrayListHome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome/src/input.txt"))) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        }

        System.out.println(strings);

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 10, 7, 8, 4, 5, 7, 2, 7, 3, 7, 6, 4, 3, 10));

        deleteEvenNumbers(numbers);
        deleteNumbersRepetitions(numbers);
    }

    public static void deleteEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(numbers.get(i));
                i--;
            }
        }

        System.out.println(numbers);
    }

    public static void deleteNumbersRepetitions(ArrayList<Integer> numbers) {
        ArrayList<Integer> newNumberList = new ArrayList<>();

        for (int i = 0; i <= numbers.size() - 1; i++) {
            for (int k = i + 1; k <= numbers.size() - 1; k++) {
                if (numbers.get(i) == numbers.get(k)) {
                    numbers.remove(k);
                    k--;
                }
            }

            newNumberList.add(numbers.get(i));
        }

        System.out.println(newNumberList);
    }
}