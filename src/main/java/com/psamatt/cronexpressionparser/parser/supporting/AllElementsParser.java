package com.psamatt.cronexpressionparser.parser.supporting;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllElementsParser implements Parser {

    private final Collection<String> all;

    public AllElementsParser(Collection<String> all) {
        this.all = all;
    }

    public AllElementsParser(IntStream stream) {
        this.all = stream.boxed().map(String::valueOf).collect(Collectors.toList());
    }

    @Override
    public Collection<String> parse(String segment) {
        if ("*".equals(segment)) {
            return all;
        }
        return Collections.emptyList();
    }
}
