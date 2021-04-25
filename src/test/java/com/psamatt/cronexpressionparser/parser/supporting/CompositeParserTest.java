package com.psamatt.cronexpressionparser.parser.supporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompositeParserTest {

    private CompositeParser parser;

    @BeforeEach
    void setUp() {
        parser = new CompositeParser(1, 60);
    }

    @Test
    void shouldParseSimpleCommaExpression() {
        Collection<String> segments = parser.parse("1,4-8");

        assertThat(segments).containsExactly("1", "4", "5", "6", "7", "8");
    }

    @Test
    void shouldParseExpressionWithIncremental() {
        Collection<String> segments = parser.parse("1,4-8,*/15");

        assertThat(segments).containsExactly("1", "4", "5", "6", "7", "8", "0", "15", "30", "45");
    }
}
