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
        System.out.printf("Принадлежит ли новому диапазону число? - %b%n", range.isInside(number));

        Range range1 = new Range(2, 5);
        Range range2 = new Range(-7, 3);
        Range range3 = range1.getIntersectionInterval(range2);
        Range[] consolidationRanges = range1.getConsolidationInterval(range2);
        Range[] differenceRanges = range1.getDifferenceInterval(range2);

        if (range3 == null) {
            System.out.println("Пересечения интервалов нет");
        } else {
            System.out.printf("Диапазон пересечения = {%.1f; %.1f}%n", range3.getFrom(), range3.getTo());
        }

        if (consolidationRanges.length == 1) {
            System.out.printf("Диапазон объединения = {%.1f; %.1f}%n", consolidationRanges[0].getFrom(), consolidationRanges[0].getTo());
        } else {
            System.out.printf("Диапазоны объединения = {%.1f; %.1f} и {%.1f; %.1f}%n", consolidationRanges[0].getFrom(), consolidationRanges[0].getTo(), consolidationRanges[1].getFrom(), consolidationRanges[1].getTo());
        }

        if (differenceRanges.length == 0) {
            System.out.println("Диапазона разности нет");
        } else if (differenceRanges.length == 1) {
            System.out.printf("Диапазон разности = {%.1f; %.1f}%n", differenceRanges[0].getFrom(), differenceRanges[0].getTo());
        } else {
            System.out.printf("Диапазоны разности = {%.1f; %.1f} и {%.1f; %.1f}%n", differenceRanges[0].getFrom(), differenceRanges[0].getTo(), differenceRanges[1].getFrom(), differenceRanges[1].getTo());
        }
    }
}