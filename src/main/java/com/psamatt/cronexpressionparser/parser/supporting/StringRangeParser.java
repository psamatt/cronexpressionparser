package com.psamatt.cronexpressionparser.parser.supporting;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringRangeParser implements Parser {

    private final List<String> all;

    public StringRangeParser(List<String> all) {
        this.all = all;
    }

    @Override
    public Collection<String> parse(String segment) {
        if (segment.contains("-")) {
            String[] segments = segment.split("-");
            int minIndex = all.indexOf(segments[0]);
            int maxIndex = all.indexOf(segments[1]);
            if (minIndex >= 0) {
                return toRange(minIndex, maxIndex);
            }
        }
        return Collections.emptyList();
    }

    private Collection<String> toRange(int minIndex, int maxIndex) {
        return IntStream.rangeClosed(minIndex, maxIndex)
                .mapToObj(i -> String.valueOf(i + 1))
                .collect(Collectors.toList());
    }
}
