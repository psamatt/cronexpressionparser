package com.psamatt.cronexpressionparser.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.cronexpressionparser.TimeUnit;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompositeParserTest {

    private CompositeParser parser;

    @BeforeEach
    void setUp() {
        parser = new CompositeParser(TimeUnit.MINUTE);
    }

    @Test
    void shouldParseSimpleCommaExpression() {
        Collection<Integer> segments = parser.parse("1,4-8");

        assertThat(segments).containsExactly(1, 4, 5, 6, 7, 8);
    }

    @Test
    void shouldParseExpressionWithIncremental() {
        Collection<Integer> segments = parser.parse("1,4-8,*/15");

        assertThat(segments).containsExactly(1, 4, 5, 6, 7, 8, 0, 15, 30, 45);
    }
}
