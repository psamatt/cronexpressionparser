package com.psamatt.cronexpressionparser;

public enum TimeUnit {
    MINUTE(1, 60),
    HOUR(1, 24),
    DAY_OF_MONTH(1, 31),
    MONTH(1, 12),
    DAY_OF_WEEK(1, 7);

    int lowerBoundary;
    int upperBoundary;

    TimeUnit(int lowerBoundary, int upperBoundary) {
        this.lowerBoundary = lowerBoundary;
        this.upperBoundary = upperBoundary;
    }

    public int getLowerBoundary() {
        return lowerBoundary;
    }

    public int getUpperBoundary() {
        return upperBoundary;
    }
}
