package com.psamatt.cronexpressionparser.parser.supporting;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IntRangeParser implements Parser {

    @Override
    public Collection<String> parse(String segment) {
        if (segment.contains("-")) {
            String[] segments = segment.split("-");
            int lower = Integer.parseInt(segments[0]);
            int upper = Integer.parseInt(segments[1]);

            return toRange(lower, upper);
        }
        return Collections.emptyList();
    }

    private List<String> toRange(int lower, int upper) {
        List<String> items = new ArrayList<>();
        while (lower <= upper) {
            items.add(String.valueOf(lower));
            lower++;
        }
        return items;
    }
}