package ru.academits.ivanova.range_main;

import ru.academits.ivanova.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(-9, -5);
        double number = -6.1;

        System.out.printf("Длина заданного диапазона = %.2f%n", range.getLength());
        System.out.printf("Принадлежит ли заданному диапазону число? - %b%n", range.isInside(number));

        range.setFrom(range.getFrom() + 3);
        range.setTo(range.getTo() + 14);

        System.out.printf("Новый числовой диапазон: от %.2f до %.2f%n", range.getFrom(), range.getTo());
        System.out.printf("Длина заданного диапазона = %.2f%n", range.getLength());
        System.out.printf("Принадлежит ли новому диапазону число? - %b%n", range.isInside(number));

        Range range1 = new Range(-7, 3);
        Range range2 = new Range(-9, 0);

        System.out.print("Диапазон пересечения: ");
        print(range1.getIntersection(range2));

        System.out.print("Диапазоны объединения: ");
        print(range1.getUnion(range2));

        System.out.print("Диапазоны разности: ");
        print(range1.getDifference(range2));
    }

    public static void print(Range range) {
        System.out.println(range);
    }

    public static void print(Range... ranges) {
        System.out.println(Arrays.toString(ranges));
    }
}