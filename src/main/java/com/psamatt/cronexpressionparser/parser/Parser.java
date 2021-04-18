package com.psamatt.cronexpressionparser.parser;

import java.util.Collection;
import java.util.Collections;

public interface Parser {

    Collection<String> parse(String segment);

    default Collection<String> parse(Collection<Parser> parsers, String segment) {
        return parsers.stream()
                .map(parser -> parser.parse(segment))
                .filter(items -> !items.isEmpty())
                .findFirst()
                .orElse(Collections.emptyList());
    }
}
