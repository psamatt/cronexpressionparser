package com.psamatt.cronexpressionparser.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.cronexpressionparser.TimeUnit;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthParserTest {

    private MonthParser parser;

    @BeforeEach
    void setUp() {
        parser = new MonthParser(TimeUnit.MONTH);
    }

    @Test
    void shouldReturnOneValueOnSingle() {
        Collection<Integer> values = parser.parse("3");

        assertThat(values).containsExactly(3);
    }

    @Test
    void shouldReturnRangeOnUsageOfHyphen() {
        Collection<Integer> values = parser.parse("0-6");

        assertThat(values).containsExactly(0, 1, 2, 3, 4, 5, 6);
    }

    @Test
    void shouldReturnExactValuesOnUsageOfComma() {
        Collection<Integer> values = parser.parse("1,2");

        assertThat(values).containsExactly(1, 2);
    }

    @Test
    void shouldReturnIncrementalOf15StartingAtZero() {
        Collection<Integer> values = parser.parse("*/4");

        assertThat(values).containsExactly(0, 4, 8);
    }

    @Test
    void shouldReturnIncrementalOf15StartingAtFive() {
        Collection<Integer> values = parser.parse("1/4");

        assertThat(values).containsExactly(1, 5, 9);
    }

    @Test
    void shouldParseListOfDays() {
        Collection<Integer> values = parser.parse("JAN-MAY");

        assertThat(values).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    void shouldReturnAll() {
        Collection<Integer> values = parser.parse("*");

        assertThat(values).hasSize(12);
    }
}
