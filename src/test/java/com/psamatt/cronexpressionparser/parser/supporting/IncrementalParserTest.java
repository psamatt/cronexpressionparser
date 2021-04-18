package com.psamatt.cronexpressionparser.parser.supporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IncrementalParserTest {

    private IncrementalParser parser;

    @BeforeEach
    void setUp() {
        parser = new IncrementalParser(0, 30);
    }

    @Test
    void shouldReturnRangeOnIncrementalWithStarMin() {
        Collection<String> actual = parser.parse("*/15");

        assertThat(actual).containsExactly("0", "15");
    }

    @Test
    void shouldReturnRangeOnIncrementalWithSpecificMin() {
        Collection<String> actual = parser.parse("5/15");

        assertThat(actual).containsExactly("5", "20");
    }
}
