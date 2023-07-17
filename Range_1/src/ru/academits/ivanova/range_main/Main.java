package ru.academits.ivanova.range_main;

import ru.academits.ivanova.range.Range;

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
        System.out.printf("Принадлежит ли новому диапазону число? - %b", range.isInside(number));
    }
}