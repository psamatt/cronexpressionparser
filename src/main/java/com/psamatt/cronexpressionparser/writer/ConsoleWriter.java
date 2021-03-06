package com.psamatt.cronexpressionparser.writer;

import com.psamatt.cronexpressionparser.ParsedCronExpression;
import java.util.Collection;
import java.util.stream.Collectors;

public class ConsoleWriter implements Writer {

    private static final int PAD_SIZE = 15;

    @Override
    public void write(ParsedCronExpression expression) {
        output("minute", expression.getMinuteOptions());
        output("hour", expression.getHourOptions());
        output("day of month", expression.getDayOfMonthOptions());
        output("month", expression.getMonthOptions());
        output("day of week", expression.getDayOfWeekOptions());
        output("command", expression.getCommand());
    }

    private void output(String title, Collection<Integer> options) {
        output(title, options.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private void output(String title, String command) {
        System.out.println(pad(title) + "" + command);
    }

    private String pad(String title) {
        return String.format("%1$-" + PAD_SIZE + "s", title);
    }
}
