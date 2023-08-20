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

    @Override
    public String toString() {
        return "(" + from + "; " + to + ")";
    }

    /**
     * Метод получения интервала-пересечения двух интервалов.
     */
    public Range getIntersection(Range range) {
        if ((range.from >= to) || (from >= range.to)) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    /**
     * Метод получения объединения двух интервалов.
     */
    public Range[] getUnion(Range range) {
        if ((range.from > to) || (from > range.to)) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    /**
     * Метод получения несимметричной разности двух интервалов - из первого интервала вычитаем второй.
     */
    public Range[] getDifference(Range range) {
        if (from < range.from) {
            if (range.from < to) {
                if (range.to < to) {
                    return new Range[]{new Range(from, range.from), new Range(range.to, to)};
                }

                return new Range[]{new Range(from, range.from)};
            }

            return new Range[]{new Range(from, to)};
        }

        if (range.to < to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[]{};
    }
}