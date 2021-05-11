package com.psamatt.cronexpressionparser.parser;

import java.util.Collection;

public interface Parser {

    Collection<Integer> parse(String segment);
}
