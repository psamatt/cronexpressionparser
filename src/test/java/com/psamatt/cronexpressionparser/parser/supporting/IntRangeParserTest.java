package com.psamatt.cronexpressionparser.parser.supporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntRangeParserTest {

    private IntRangeParser parser;

    @BeforeEach
    void setUp() {
        parser = new IntRangeParser();
    }

    @Test
    void shouldReturnIntRange() {
        Collection<String> actual = parser.parse("1-3");

        assertThat(actual).containsExactly("1", "2", "3");
    }

    @Test
    void shouldReturnEmptyOnNoRange() {
        Collection<String> actual = parser.parse("1");

        assertThat(actual).isEmpty();
    }
}
