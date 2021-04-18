package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.parser.supporting.AllElementsParser;
import com.psamatt.cronexpressionparser.parser.supporting.IncrementalParser;
import com.psamatt.cronexpressionparser.parser.supporting.IntRangeParser;
import com.psamatt.cronexpressionparser.parser.supporting.MultipleValueParser;
import com.psamatt.cronexpressionparser.parser.supporting.SimpleParser;
import com.psamatt.cronexpressionparser.parser.supporting.StringRangeParser;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class MonthParser implements Parser {

    private final List<Parser> parsers;

    public MonthParser() {
        parsers =
                List.of(
                        new StringRangeParser(
                                List.of(
                                        "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
                                        "SEP", "OCT", "NOV", "DEC")),
                        new IntRangeParser(),
                        new MultipleValueParser(),
                        new IncrementalParser(0, 12),
                        new AllElementsParser(IntStream.rangeClosed(1, 12)),
                        new SimpleParser());
    }

    @Override
    public Collection<String> parse(String segment) {
        return parse(parsers, segment);
    }
}
