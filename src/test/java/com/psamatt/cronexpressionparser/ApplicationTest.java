package com.psamatt.cronexpressionparser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    private Application app;

    @BeforeEach
    void setUp() {
        app = new Application();
    }

    @Test
    void shouldThrowCronExpressionNotProvidedException() {
        Throwable t = catchThrowable(() -> app.run(new String[] {}));

        assertThat(t)
                .isExactlyInstanceOf(CronExpressionNotProvidedException.class)
                .hasMessage("Cron Expression not provided");
    }
}
