package com.psamatt.cronexpressionparser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.psamatt.cronexpressionparser.parser.Parser;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CronExpressionParserTest {

    private static final List<String> PARSED_MINUTES = List.of("15");
    private static final List<String> PARSED_HOURS = List.of("0");
    private static final List<String> PARSED_DAY_OF_MONTHS = List.of("1", "15");
    private static final List<String> PARSED_MONTHS = List.of("1");
    private static final List<String> PARSED_DAY_OF_WEEKS = List.of("1", "2");
    private static final String COMMAND = "/usr/bin/find";

    @Mock private Parser minuteParser;
    @Mock private Parser hourParser;
    @Mock private Parser dayOfMonthParser;
    @Mock private Parser monthParser;
    @Mock private Parser dayOfWeekParser;

    private CronExpressionParser parser;

    @BeforeEach
    void setUp() {
        parser =
                new CronExpressionParser(
                        minuteParser, hourParser, dayOfMonthParser, monthParser, dayOfWeekParser);
    }

    @Test
    void shouldParseExpression() {
        CronExpression expression = givenParsedExpression();

        ParsedCronExpression result = parser.parse(expression);

        assertThat(result)
                .isEqualTo(
                        new ParsedCronExpression(
                                PARSED_MINUTES,
                                PARSED_HOURS,
                                PARSED_DAY_OF_MONTHS,
                                PARSED_MONTHS,
                                PARSED_DAY_OF_WEEKS,
                                COMMAND));
    }

    private CronExpression givenParsedExpression() {
        CronExpression expression = CronExpression.fromString("*/15 0 1,15 1 1-2 /usr/bin/find");

        given(minuteParser.parse("*/15")).willReturn(PARSED_MINUTES);
        given(hourParser.parse("0")).willReturn(PARSED_HOURS);
        given(dayOfMonthParser.parse("1,15")).willReturn(PARSED_DAY_OF_MONTHS);
        given(monthParser.parse("1")).willReturn(PARSED_MONTHS);
        given(dayOfWeekParser.parse("1-2")).willReturn(PARSED_DAY_OF_WEEKS);

        return expression;
    }
}
