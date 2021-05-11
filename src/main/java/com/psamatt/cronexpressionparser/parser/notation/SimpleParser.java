package com.psamatt.cronexpressionparser.parser.notation;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.Collection;
import java.util.List;

public class SimpleParser implements Parser {
    @Override
    public Collection<Integer> parse(String segment) {
        return List.of(Integer.parseInt(segment));
    }
}
