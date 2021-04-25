package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.parser.supporting.CompositeParser;
import com.psamatt.cronexpressionparser.parser.supporting.StringRangeParser;
import java.util.Collection;
import java.util.List;

public class DayOfWeekParser implements Parser {

    private final List<Parser> parsers;

    public DayOfWeekParser() {
        parsers =
                List.of(
                        new StringRangeParser(
                                List.of("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")),
                        new CompositeParser(1, 7));
    }

    @Override
    public Collection<String> parse(String segment) {
        return parse(parsers, segment);
    }
}
