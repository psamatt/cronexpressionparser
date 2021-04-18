package com.psamatt.cronexpressionparser;

import com.psamatt.cronexpressionparser.writer.ConsoleWriter;

public class Application {

    public static void main(String[] args) {
        CronExpression expression = buildCronExpression(args);
        ParsedCronExpression parsed = new CronExpressionParser().parse(expression);
        new ConsoleWriter().write(parsed);
    }

    private static CronExpression buildCronExpression(String[] args) {
        if (args.length < 1) {
            throw new CronExpressionNotProvidedException();
        }
        return CronExpression.fromString(args[0]);
    }
}
