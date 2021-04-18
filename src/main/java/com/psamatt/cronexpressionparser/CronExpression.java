package com.psamatt.cronexpressionparser;

import lombok.Value;

@Value
public class CronExpression {

    String minute;
    String hour;
    String dayOfMonth;
    String month;
    String dayOfWeek;
    String command;

    public static CronExpression fromString(String expression) {
        String[] segments = split(expression);
        return new CronExpression(
                segments[0], segments[1], segments[2], segments[3], segments[4], segments[5]);
    }

    private static String[] split(String expression) {
        String[] segments = expression.split(" ");
        if (segments.length != 6) {
            throw new InvalidCronExpressionException(expression);
        }
        return segments;
    }
}
