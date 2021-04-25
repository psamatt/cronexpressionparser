package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.parser.supporting.CompositeParser;
import com.psamatt.cronexpressionparser.parser.supporting.StringRangeParser;
import java.util.Collection;
import java.util.List;

public class MonthParser implements Parser {

    private final List<Parser> parsers;

    public MonthParser() {
        parsers =
                List.of(
                        new StringRangeParser(
                                List.of(
                                        "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
                                        "SEP", "OCT", "NOV", "DEC")),
                        new CompositeParser(1, 12));
    }

    @Override
    public Collection<String> parse(String segment) {
        return parse(parsers, segment);
    }
}
