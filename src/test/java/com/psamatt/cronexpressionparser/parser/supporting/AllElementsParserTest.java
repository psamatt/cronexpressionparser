package com.psamatt.cronexpressionparser.parser.supporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AllElementsParserTest {

    private static final List<String> ALL = List.of("a", "b");

    private AllElementsParser parser;

    @BeforeEach
    void setUp() {
        parser = new AllElementsParser(ALL);
    }

    @Test
    void shouldReturnAllOnStar() {
        Collection<String> actual = parser.parse("*");

        assertThat(actual).containsAll(ALL);
    }

    @Test
    void shouldReturnEmotyOnNotStar() {
        Collection<String> actual = parser.parse("1");

        assertThat(actual).isEmpty();
    }
}
