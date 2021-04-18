package com.psamatt.cronexpressionparser.parser.supporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.Test;

class SimpleParserTest {

    @Test
    void shouldReturnSimpleValue() {
        SimpleParser parser = new SimpleParser();
        Collection<String> actual = parser.parse("3");

        assertThat(actual).containsExactly("3");
    }
}
