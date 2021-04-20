package com.psamatt.cronexpressionparser;

import com.psamatt.cronexpressionparser.writer.ConsoleWriter;
import com.psamatt.cronexpressionparser.writer.Writer;

public class Application {

    private final CronExpressionParser parser;
    private final Writer writer;

    public Application() {
        this(new CronExpressionParser(), new ConsoleWriter());
    }

    public Application(CronExpressionParser parser, Writer writer) {
        this.parser = parser;
        this.writer = writer;
    }

    public void run(String[] args) {
        CronExpression expression = buildCronExpression(args);
        ParsedCronExpression parsed = parser.parse(expression);
        writer.write(parsed);
    }

    private static CronExpression buildCronExpression(String[] args) {
        if (args.length < 1) {
            throw new CronExpressionNotProvidedException();
        }
        return CronExpression.fromString(args[0]);
    }
}
