package com.psamatt.cronexpressionparser.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthParserTest {

    private MonthParser parser;

    @BeforeEach
    void setUp() {
        parser = new MonthParser();
    }

    @Test
    void shouldReturnOneValueOnSingle() {
        Collection<String> values = parser.parse("3");

        assertThat(values).containsExactly("3");
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
        Collection<String> values = parser.parse("*/4");

        assertThat(values).containsExactly("0", "4", "8");
    }

    @Test
    void shouldReturnIncrementalOf15StartingAtFive() {
        Collection<String> values = parser.parse("1/4");

        assertThat(values).containsExactly("1", "5", "9");
    }

    @Test
    void shouldParseListOfDays() {
        Collection<String> values = parser.parse("JAN-MAY");

        assertThat(values).containsExactly("JAN", "FEB", "MAR", "APR", "MAY");
    }

    @Test
    void shouldReturnAll() {
        Collection<String> values = parser.parse("*");

        assertThat(values).hasSize(12);
    }
}
