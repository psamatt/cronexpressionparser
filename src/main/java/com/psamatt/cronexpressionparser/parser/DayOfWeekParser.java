package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.TimeUnit;
import java.util.Collection;

public class DayOfWeekParser implements Parser {

    private final Parser parser;

    public DayOfWeekParser(TimeUnit timeUnit) {
        parser = new CompositeParser(timeUnit);
    }

    @Override
    public Collection<Integer> parse(String segment) {
        String replacedSegment = replaceNamedDays(segment);
        return parser.parse(replacedSegment);
    }

    private String replaceNamedDays(String segment) {
        return segment.replace("MON", "1")
                .replace("TUE", "2")
                .replace("WED", "3")
                .replace("THU", "4")
                .replace("FRI", "5")
                .replace("SAT", "6")
                .replace("SUN", "7");
    }
}
