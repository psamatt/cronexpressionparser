package com.psamatt.cronexpressionparser;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

class ApplicationTest {

    @Test
    void shouldThrowCronExpressionNotProvidedException() {
        Throwable t = catchThrowable(() -> Application.main(new String[] {}));

        assertThat(t)
                .isExactlyInstanceOf(CronExpressionNotProvidedException.class)
                .hasMessage("Cron Expression not provided");
    }

    @Test
    void shouldOutputResultFromExpression() throws Exception {
        String actual =
                tapSystemOut(
                        () -> Application.main(new String[] {"*/15 0 1,15 * 1-5 /usr/bin/find"}));

        assertThat(actual)
                .isEqualTo(
                        """
minute         0 15 30 45
hour           0
day of month   1 15
month          1 2 3 4 5 6 7 8 9 10 11 12
day of week    1 2 3 4 5
command        /usr/bin/find
                """);
    }
}