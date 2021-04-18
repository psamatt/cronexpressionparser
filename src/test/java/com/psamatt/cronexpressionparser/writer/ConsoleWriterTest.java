package com.psamatt.cronexpressionparser.writer;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.cronexpressionparser.ParsedCronExpression;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleWriterTest {

    private static final List<String> PARSED_MINUTES = List.of("15");
    private static final List<String> PARSED_HOURS = List.of("0");
    private static final List<String> PARSED_DAY_OF_MONTHS = List.of("1", "15");
    private static final List<String> PARSED_MONTHS = List.of("1", "2", "3", "4");
    private static final List<String> PARSED_DAY_OF_WEEKS = List.of("1", "2", "3", "4", "5");
    private static final String COMMAND = "/usr/bin/find";

    private ConsoleWriter writer;

    @BeforeEach
    void setUp() {
        writer = new ConsoleWriter();
    }

    @Test
    void shouldOutputAsFormattedTable() throws Exception {
        String actual = tapSystemOut(() -> writer.write(buildParsedExpression()));

        assertThat(actual)
                .isEqualTo(
                        """
minute         15
hour           0
day of month   1 15
month          1 2 3 4
day of week    1 2 3 4 5
command        /usr/bin/find
                """);
    }

    private static ParsedCronExpression buildParsedExpression() {
        return new ParsedCronExpression(
                PARSED_MINUTES,
                PARSED_HOURS,
                PARSED_DAY_OF_MONTHS,
                PARSED_MONTHS,
                PARSED_DAY_OF_WEEKS,
                COMMAND);
    }
}
