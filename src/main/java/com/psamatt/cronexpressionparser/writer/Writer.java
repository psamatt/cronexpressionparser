package com.psamatt.cronexpressionparser.writer;

import com.psamatt.cronexpressionparser.ParsedCronExpression;

public interface Writer {

    void write(ParsedCronExpression expression);
}
