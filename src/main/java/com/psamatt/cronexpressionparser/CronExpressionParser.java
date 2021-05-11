package com.psamatt.cronexpressionparser;

import com.psamatt.cronexpressionparser.parser.CompositeParser;
import com.psamatt.cronexpressionparser.parser.DayOfWeekParser;
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
                new CompositeParser(TimeUnit.MINUTE),
                new CompositeParser(TimeUnit.HOUR),
                new CompositeParser(TimeUnit.DAY_OF_MONTH),
                new MonthParser(TimeUnit.MONTH),
                new DayOfWeekParser(TimeUnit.DAY_OF_WEEK));
    }

    public ParsedCronExpression parse(CronExpression expression) {
        Collection<Integer> minuteOptions = minuteParser.parse(expression.getMinute());
        Collection<Integer> hourOptions = hourParser.parse(expression.getHour());
        Collection<Integer> dayOfMonthOptions = dayOfMonthParser.parse(expression.getDayOfMonth());
        Collection<Integer> monthOptions = monthParser.parse(expression.getMonth());
        Collection<Integer> dayOfWeekOptions = dayOfWeekParser.parse(expression.getDayOfWeek());

        return new ParsedCronExpression(
                minuteOptions,
                hourOptions,
                dayOfMonthOptions,
                monthOptions,
                dayOfWeekOptions,
                expression.getCommand());
    }
}
