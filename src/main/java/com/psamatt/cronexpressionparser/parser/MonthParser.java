package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.TimeUnit;
import java.util.Collection;

public class MonthParser implements Parser {

    private final Parser parser;

    public MonthParser(TimeUnit timeUnit) {
        parser = new CompositeParser(timeUnit);
    }

    public Collection<Integer> parse(String segment) {
        String replacedSegment = replaceNamedDays(segment);

        return parser.parse(replacedSegment);
    }

    private String replaceNamedDays(String segment) {
        return segment.replace("JAN", "1")
                .replace("FEB", "2")
                .replace("MAR", "3")
                .replace("APR", "4")
                .replace("MAY", "5")
                .replace("JUN", "6")
                .replace("JUL", "7")
                .replace("AUG", "8")
                .replace("SEP", "9")
                .replace("OCT", "10")
                .replace("NOV", "11")
                .replace("DEC", "12");
    }
}
