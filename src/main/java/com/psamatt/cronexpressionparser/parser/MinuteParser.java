package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.parser.supporting.CompositeParser;
import java.util.Collection;
import java.util.List;

public class MinuteParser implements Parser {

    private final List<Parser> parsers;

    public MinuteParser() {
        parsers = List.of(new CompositeParser(1, 60));
    }

    @Override
    public Collection<String> parse(String segment) {
        return parse(parsers, segment);
    }
}
