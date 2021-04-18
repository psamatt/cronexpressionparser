package com.psamatt.cronexpressionparser.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayOfMonthParserTest {

    private DayOfMonthParser parser;

    @BeforeEach
    void setUp() {
        parser = new DayOfMonthParser();
    }

    @Test
    void shouldReturnOneValueOnSingle() {
        Collection<String> values = parser.parse("20");

        assertThat(values).containsExactly("20");
    }

    @Test
    void shouldReturnRangeOnUsageOfHyphen() {
        Collection<String> values = parser.parse("0-6");

        assertThat(values).containsExactly("0", "1", "2", "3", "4", "5", "6");
    }

    @Test
    void shouldReturnExactValuesOnUsageOfComma() {
        Collection<String> values = parser.parse("1,2");

        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void shouldReturnIncrementalOf15StartingAtZero() {
        Collection<String> values = parser.parse("*/10");

        assertThat(values).containsExactly("0", "10", "20", "30");
    }

    @Test
    void shouldReturnIncrementalOf15StartingAtFive() {
        Collection<String> values = parser.parse("1/10");

        assertThat(values).containsExactly("1", "11", "21");
    }

    @Test
    void shouldReturnAll() {
        Collection<String> values = parser.parse("*");

        assertThat(values).hasSize(31);
    }
}
