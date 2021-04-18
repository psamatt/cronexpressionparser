package com.psamatt.cronexpressionparser.parser.supporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultipleValueParserTest {

    private MultipleValueParser parser;

    @BeforeEach
    void setUp() {
        parser = new MultipleValueParser();
    }

    @Test
    void shouldParseMultipleValues() {
        Collection<String> actual = parser.parse("1,2");

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void shouldReturnEmptyListOnNoMultiples() {
        Collection<String> actual = parser.parse("1");

        assertThat(actual).isEmpty();
    }
}
