package com.psamatt.cronexpressionparser.parser.notation;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IncrementalParser implements Parser {

    private final int min;
    private final int max;

    public IncrementalParser(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Collection<Integer> parse(String segment) {
        if (segment.contains("/")) {
            String[] segments = segment.split("/");
            int minValue = getMinValue(segments[0]);
            return iterateToMax(minValue, Integer.parseInt(segments[1]));
        }
        return Collections.emptyList();
    }

    private Collection<Integer> iterateToMax(int minValue, int iterator) {
        return IntStream.iterate(minValue, i -> i < max, i -> i + iterator)
                .boxed()
                .collect(Collectors.toList());
    }

    private int getMinValue(String segment) {
        if ("*".equals(segment)) {
            return min;
        }
        return Integer.parseInt(segment);
    }
}
