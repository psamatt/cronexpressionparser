package com.psamatt.cronexpressionparser.parser.supporting;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MultipleValueParser implements Parser {

    @Override
    public Collection<String> parse(String segment) {
        if (segment.contains(",")) {
            return List.of(segment.split(","));
        }
        return Collections.emptyList();
    }
}
