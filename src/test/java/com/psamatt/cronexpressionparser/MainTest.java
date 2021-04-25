package com.psamatt.cronexpressionparser;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void shouldOutputResultFromExpression() throws Exception {
        String actual =
                tapSystemOut(() -> Main.main(new String[] {"*/15 0 1,15 * 1-5 /usr/bin/find"}));

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

    @Test
    void shouldParseTextualDays() throws Exception {
        String actual =
                tapSystemOut(() -> Main.main(new String[] {"1 1 1 1 MON-THU /usr/bin/find"}));

        assertThat(actual)
                .isEqualTo(
                        """
minute         1
hour           1
day of month   1
month          1
day of week    1 2 3 4
command        /usr/bin/find
              """);
    }

    @Test
    void shouldParseComplicatedMinuteSequence() throws Exception {
        String actual =
                tapSystemOut(() -> Main.main(new String[] {"1,4-8,*/15 1 1 1 1 /usr/bin/find"}));

        assertThat(actual)
                .isEqualTo(
                        """
minute         1 4 5 6 7 8 0 15 30 45
hour           1
day of month   1
month          1
day of week    1
command        /usr/bin/find
              """);
    }
}
