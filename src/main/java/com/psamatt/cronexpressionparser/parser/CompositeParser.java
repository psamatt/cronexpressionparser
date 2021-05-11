package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.TimeUnit;
import com.psamatt.cronexpressionparser.parser.notation.IncrementalParser;
import com.psamatt.cronexpressionparser.parser.notation.IntRangeParser;
import com.psamatt.cronexpressionparser.parser.notation.SimpleParser;
import com.psamatt.cronexpressionparser.parser.notation.WildcardParser;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompositeParser implements Parser {

    private final Collection<Parser> parsers;

    public CompositeParser(TimeUnit timeUnit) {
        this(timeUnit.getLowerBoundary(), timeUnit.getUpperBoundary());
    }

    private CompositeParser(int min, int max) {
        this.parsers =
                List.of(
                        new IntRangeParser(),
                        new IncrementalParser(min - 1, max),
                        new WildcardParser(IntStream.rangeClosed(min, max)),
                        new SimpleParser());
    }

    @Override
    public Collection<Integer> parse(String segment) {
        return Arrays.stream(segment.split(","))
                .map(item -> parse(parsers, item))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private Collection<Integer> parse(Collection<Parser> parsers, String segment) {
        return parsers.stream()
                .map(parser -> parser.parse(segment))
                .filter(items -> !items.isEmpty())
                .findFirst()
                .orElse(Collections.emptyList());
    }
}
