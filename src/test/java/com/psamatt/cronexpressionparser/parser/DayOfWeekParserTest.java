package com.psamatt.cronexpressionparser.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayOfWeekParserTest {

    private DayOfWeekParser parser;

    @BeforeEach
    void setUp() {
        parser = new DayOfWeekParser();
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
        Collection<String> values = parser.parse("*/2");

        assertThat(values).containsExactly("0", "2", "4");
    }

    @Test
    void shouldReturnIncrementalOf15StartingAtFive() {
        Collection<String> values = parser.parse("1/2");

        assertThat(values).containsExactly("1", "3", "5");
    }

    @Test
    void shouldParseListOfDays() {
        Collection<String> values = parser.parse("MON-THU");

        assertThat(values).containsExactly("MON", "TUE", "WED", "THU");
    }

    @Test
    void shouldReturnAll() {
        Collection<String> values = parser.parse("*");

        assertThat(values).hasSize(7);
    }
}
