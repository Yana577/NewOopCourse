package ru.academits.ivanova.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return (number >= from) && (number <= to);
    }

    /*
     Метод получения интервала-пересечения двух интервалов.
   */
    public Range getIntersectionInterval(Range range2) {
        if ((range2.from >= to) || (from >= range2.to)) {
            return null;
        }

        Range interval = new Range(from, to);

        interval.from = Math.max(from, range2.from);
        interval.to = Math.min(to, range2.to);

        return interval;
    }

    /*
     Метод получения объединения двух интервалов.
   */
    public Range[] getConsolidationInterval(Range range2) {
        Range interval1 = new Range(from, to);

        if ((range2.from > to) || (from > range2.to)) {
            Range interval2 = new Range(from, to);
            interval1.from = from;
            interval1.to = to;
            interval2.from = range2.from;
            interval2.to = range2.to;

            return new Range[]{interval1, interval2};
        }

        interval1.from = Math.min(from, range2.from);
        interval1.to = Math.max(to, range2.to);

        return new Range[]{interval1};
    }

    /*
     Метод получения разности двух интервалов.
   */
    public Range[] getDifferenceInterval(Range range2) {
        if ((range2.from >= to) || (from >= range2.to) || ((from == range2.from) && (to == range2.to))) {
            return new Range[]{};
        }

        if ((from != range2.from) && (to != range2.to)) {
            Range interval1 = new Range(from, to);
            Range interval2 = new Range(from, to);
            interval1.from = Math.min(from, range2.from);
            interval1.to = Math.max(from, range2.from);
            interval2.from = Math.min(to, range2.to);
            interval2.to = Math.max(to, range2.to);

            return new Range[]{interval1, interval2};
        }

        Range interval1 = new Range(from, to);

        if (from == range2.from) {
            interval1.from = Math.min(to, range2.to);
            interval1.to = Math.max(to, range2.to);

            return new Range[]{interval1};
        }

        interval1.from = Math.min(from, range2.from);
        interval1.to = Math.max(from, range2.from);

        return new Range[]{interval1};
    }
}