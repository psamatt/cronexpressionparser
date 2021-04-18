package com.psamatt.cronexpressionparser.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinuteParserTest {

    private MinuteParser parser;

    @BeforeEach
    void setUp() {
        parser = new MinuteParser();
    }

    @Test
    void shouldReturnOneValueOnSingle() {
        Collection<String> values = parser.parse("20");

        assertThat(values).containsExactly("20");
    }

    @Test
    void shouldReturnRangeOnUsageOfHyphen() {
        Collection<String> values = parser.parse("10-12");

        assertThat(values).containsExactly("10", "11", "12");
    }

    @Test
    void shouldReturnExactValuesOnUsageOfComma() {
        Collection<String> values = parser.parse("10,12");

        assertThat(values).containsExactly("10", "12");
    }

    @Test
    void shouldReturnIncrementalOf15StartingAtZero() {
        Collection<String> values = parser.parse("*/15");

        assertThat(values).containsExactly("0", "15", "30", "45");
    }

    @Test
    void shouldReturnIncrementalOf15StartingAtFive() {
        Collection<String> values = parser.parse("5/15");

        assertThat(values).containsExactly("5", "20", "35", "50");
    }

    @Test
    void shouldReturnAll() {
        Collection<String> values = parser.parse("*");

        assertThat(values).hasSize(60);
    }
}
