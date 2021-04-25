package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.parser.supporting.CompositeParser;
import java.util.Collection;
import java.util.List;

public class HourParser implements Parser {

    private final List<Parser> parsers;

    public HourParser() {
        parsers = List.of(new CompositeParser(1, 24));
    }

    @Override
    public Collection<String> parse(String segment) {
        return parse(parsers, segment);
    }
}
