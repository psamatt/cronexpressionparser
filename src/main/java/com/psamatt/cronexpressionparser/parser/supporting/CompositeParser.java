package com.psamatt.cronexpressionparser.parser.supporting;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class CompositeParser implements Parser {

    private final Collection<Parser> parsers;

    public CompositeParser(int min, int max) {
        this.parsers =
                List.of(
                        new IntRangeParser(),
                        new IncrementalParser(min - 1, max),
                        new AllElementsParser(IntStream.rangeClosed(min, max)),
                        new SimpleParser());
    }

    @Override
    public Collection<String> parse(String segment) {
        String[] segments = segment.split(",");
        List<String> items = Arrays.asList(segments);
        List<String> allOptions = new ArrayList<>();
        for (String item : items) {
            Collection<String> parsedItem = parse(parsers, item);
            allOptions.addAll(parsedItem);
        }
        return allOptions;
    }
}
