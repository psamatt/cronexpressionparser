package com.psamatt.cronexpressionparser.parser.notation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WildcardParserTest {

    private static final List<Integer> ALL = List.of(1, 2);

    private WildcardParser parser;

    @BeforeEach
    void setUp() {
        parser = new WildcardParser(ALL);
    }

    @Test
    void shouldReturnAllOnStar() {
        Collection<Integer> actual = parser.parse("*");

        assertThat(actual).containsAll(ALL);
    }

    @Test
    void shouldReturnEmotyOnNotStar() {
        Collection<Integer> actual = parser.parse("1");

        assertThat(actual).isEmpty();
    }
}
