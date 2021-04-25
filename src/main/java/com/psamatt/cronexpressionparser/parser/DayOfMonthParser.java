package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.parser.supporting.CompositeParser;
import java.util.Collection;
import java.util.List;

public class DayOfMonthParser implements Parser {

    private final List<Parser> parsers;

    public DayOfMonthParser() {
        parsers = List.of(new CompositeParser(1, 31));
    }

    @Override
    public Collection<String> parse(String segment) {
        return parse(parsers, segment);
    }
}
