package com.psamatt.cronexpressionparser.parser.supporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringRangeParserTest {

    private StringRangeParser parser;

    @BeforeEach
    void setUp() {
        parser = new StringRangeParser(List.of("MON", "TUE", "WED", "THU"));
    }

    @Test
    void shouldReturnRange() {
        Collection<String> actual = parser.parse("TUE-WED");

        assertThat(actual).containsExactly("TUE", "WED");
    }
}
