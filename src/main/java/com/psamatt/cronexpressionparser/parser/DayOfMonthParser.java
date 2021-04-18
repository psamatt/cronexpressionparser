package com.psamatt.cronexpressionparser.parser;

import com.psamatt.cronexpressionparser.parser.supporting.AllElementsParser;
import com.psamatt.cronexpressionparser.parser.supporting.IncrementalParser;
import com.psamatt.cronexpressionparser.parser.supporting.IntRangeParser;
import com.psamatt.cronexpressionparser.parser.supporting.MultipleValueParser;
import com.psamatt.cronexpressionparser.parser.supporting.SimpleParser;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class DayOfMonthParser implements Parser {

    private final List<Parser> parsers;

    public DayOfMonthParser() {
        parsers =
                List.of(
                        new IntRangeParser(),
                        new MultipleValueParser(),
                        new IncrementalParser(0, 31),
                        new AllElementsParser(IntStream.rangeClosed(1, 31)),
                        new SimpleParser());
    }

    @Override
    public Collection<String> parse(String segment) {
        return parse(parsers, segment);
    }
}
