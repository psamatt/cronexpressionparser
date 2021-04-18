package com.psamatt.cronexpressionparser.parser.supporting;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.Collection;
import java.util.List;

public class SimpleParser implements Parser {
    @Override
    public Collection<String> parse(String segment) {
        return List.of(segment);
    }
}
