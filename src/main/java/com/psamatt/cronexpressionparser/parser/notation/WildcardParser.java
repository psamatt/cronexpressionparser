package com.psamatt.cronexpressionparser.parser.notation;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WildcardParser implements Parser {

    private final Collection<Integer> all;

    public WildcardParser(Collection<Integer> all) {
        this.all = all;
    }

    public WildcardParser(IntStream stream) {
        this(stream.boxed().collect(Collectors.toList()));
    }

    @Override
    public Collection<Integer> parse(String segment) {
        if ("*".equals(segment)) {
            return all;
        }
        return Collections.emptyList();
    }
}
