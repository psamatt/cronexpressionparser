package com.psamatt.cronexpressionparser;

import com.psamatt.cronexpressionparser.parser.DayOfMonthParser;
import com.psamatt.cronexpressionparser.parser.DayOfWeekParser;
import com.psamatt.cronexpressionparser.parser.HourParser;
import com.psamatt.cronexpressionparser.parser.MinuteParser;
import com.psamatt.cronexpressionparser.parser.MonthParser;
import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.Collection;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CronExpressionParser {

    private final Parser minuteParser;
    private final Parser hourParser;
    private final Parser dayOfMonthParser;
    private final Parser monthParser;
    private final Parser dayOfWeekParser;

    public CronExpressionParser() {
        this(
                new MinuteParser(),
                new HourParser(),
                new DayOfMonthParser(),
                new MonthParser(),
                new DayOfWeekParser());
    }

    public ParsedCronExpression parse(CronExpression expression) {
        Collection<String> minuteOptions = minuteParser.parse(expression.getMinute());
        Collection<String> hourOptions = hourParser.parse(expression.getHour());
        Collection<String> dayOfMonthOptions = dayOfMonthParser.parse(expression.getDayOfMonth());
        Collection<String> monthOptions = monthParser.parse(expression.getMonth());
        Collection<String> dayOfWeekOptions = dayOfWeekParser.parse(expression.getDayOfWeek());

        return new ParsedCronExpression(
                minuteOptions,
                hourOptions,
                dayOfMonthOptions,
                monthOptions,
                dayOfWeekOptions,
                expression.getCommand());
    }
}
