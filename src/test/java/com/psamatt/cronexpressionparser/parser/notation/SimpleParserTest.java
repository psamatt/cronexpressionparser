package com.psamatt.cronexpressionparser.parser.notation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.Test;

class SimpleParserTest {

    @Test
    void shouldReturnSimpleValue() {
        SimpleParser parser = new SimpleParser();
        Collection<Integer> actual = parser.parse("3");

        assertThat(actual).containsExactly(3);
    }
}
