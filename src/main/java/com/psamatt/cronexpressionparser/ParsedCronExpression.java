package com.psamatt.cronexpressionparser;

import java.util.Collection;
import lombok.Value;

@Value
public class ParsedCronExpression {

    Collection<String> minuteOptions;
    Collection<String> hourOptions;
    Collection<String> dayOfMonthOptions;
    Collection<String> monthOptions;
    Collection<String> dayOfWeekOptions;
    String command;

    public ParsedCronExpression(
            Collection<String> minuteOptions,
            Collection<String> hourOptions,
            Collection<String> dayOfMonthOptions,
            Collection<String> monthOptions,
            Collection<String> dayOfWeekOptions,
            String command) {
        this.minuteOptions = minuteOptions;
        this.hourOptions = hourOptions;
        this.dayOfMonthOptions = dayOfMonthOptions;
        this.monthOptions = monthOptions;
        this.dayOfWeekOptions = dayOfWeekOptions;
        this.command = command;
    }
}
