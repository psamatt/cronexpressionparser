package com.psamatt.cronexpressionparser;

import java.util.Collection;
import lombok.Value;

@Value
public class ParsedCronExpression {

    Collection<Integer> minuteOptions;
    Collection<Integer> hourOptions;
    Collection<Integer> dayOfMonthOptions;
    Collection<Integer> monthOptions;
    Collection<Integer> dayOfWeekOptions;
    String command;

    public ParsedCronExpression(
            Collection<Integer> minuteOptions,
            Collection<Integer> hourOptions,
            Collection<Integer> dayOfMonthOptions,
            Collection<Integer> monthOptions,
            Collection<Integer> dayOfWeekOptions,
            String command) {
        this.minuteOptions = minuteOptions;
        this.hourOptions = hourOptions;
        this.dayOfMonthOptions = dayOfMonthOptions;
        this.monthOptions = monthOptions;
        this.dayOfWeekOptions = dayOfWeekOptions;
        this.command = command;
    }
}
