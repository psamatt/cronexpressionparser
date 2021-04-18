package com.psamatt.cronexpressionparser;

import static java.lang.String.format;

public class InvalidCronExpressionException extends RuntimeException {

    public InvalidCronExpressionException(String expression) {
        super(format("Invalid Cron Expression [%s]", expression));
    }
}
