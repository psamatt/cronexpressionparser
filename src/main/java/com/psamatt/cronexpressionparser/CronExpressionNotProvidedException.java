package com.psamatt.cronexpressionparser;

public class CronExpressionNotProvidedException extends RuntimeException {

    public CronExpressionNotProvidedException() {
        super("Cron Expression not provided");
    }
}
