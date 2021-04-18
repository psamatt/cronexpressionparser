package com.psamatt.cronexpressionparser.parser.supporting;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class IncrementalParser implements Parser {

    private final int min;
    private final int max;

    public IncrementalParser(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Collection<String> parse(String segment) {
        if (segment.contains("/")) {
            String[] segments = segment.split("/");
            int minValue = getMinValue(segments[0]);
            Collection<Integer> numbers = iterateToMax(minValue, Integer.parseInt(segments[1]));
            return numbers.stream().map(String::valueOf).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private Collection<Integer> iterateToMax(int minValue, int iterator) {
        int counter = minValue;
        Collection<Integer> numbers = new ArrayList<>();
        while (counter < max) {
            numbers.add(counter);
            counter = counter + iterator;
        }
        return numbers;
    }

    private int getMinValue(String segment) {
        if ("*".equals(segment)) {
            return min;
        }
        return Integer.parseInt(segment);
    }
}
