package com.psamatt.cronexpressionparser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

class CronExpressionTest {

    @Test
    void shouldParseMinute() {
        CronExpression expression = CronExpression.fromString("*/15 0 1,15 * 1-5 /usr/bin/find");

        assertThat(expression.getMinute()).isEqualTo("*/15");
    }

    @Test
    void shouldParseHour() {
        CronExpression expression = CronExpression.fromString("*/15 0 1,15 * 1-5 /usr/bin/find");

        assertThat(expression.getHour()).isEqualTo("0");
    }

    @Test
    void shouldParseDayOfMonth() {
        CronExpression expression = CronExpression.fromString("*/15 0 1,15 * 1-5 /usr/bin/find");

        assertThat(expression.getDayOfMonth()).isEqualTo("1,15");
    }

    @Test
    void shouldParseMonth() {
        CronExpression expression = CronExpression.fromString("*/15 0 1,15 * 1-5 /usr/bin/find");

        assertThat(expression.getMonth()).isEqualTo("*");
    }

    @Test
    void shouldParseDayOfWeek() {
        CronExpression expression = CronExpression.fromString("*/15 0 1,15 * 1-5 /usr/bin/find");

        assertThat(expression.getDayOfWeek()).isEqualTo("1-5");
    }

    @Test
    void shouldParseCommand() {
        CronExpression expression = CronExpression.fromString("*/15 0 1,15 * 1-5 /usr/bin/find");

        assertThat(expression.getCommand()).isEqualTo("/usr/bin/find");
    }

    @Test
    void shouldThrowInvalidCronExpressionExceptionOnInvalidFormat() {

        Throwable t = catchThrowable(() -> CronExpression.fromString("hello world"));

        assertThat(t)
                .isExactlyInstanceOf(InvalidCronExpressionException.class)
                .hasMessage("Invalid Cron Expression [hello world]");
    }
}
