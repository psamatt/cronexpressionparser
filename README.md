## Cron Expression Parser

Small CLI app to parse a standard cron expression to yield what the expression means in more human readable form

For example, the follow input
```text
*/15 0 1,15 * 1-5 /usr/bin/find
```
should output as follows
```text
minute         0 15 30 45
hour           0
day of month   1 15
month          1 2 3 4 5 6 7 8 9 10 11 12
day of week    1 2 3 4 5
command        /usr/bin/find
```

### Getting started
Build Jar
```shell
./gradlew clean assemble
```
Execute application
```shell
java -jar build/libs/cronexpressionparser*.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```

### Tools used
This has been built using the following tools
- Java15
- Junit5 
- Mockito
- AssertJ
- Lombok
- Gradle

### TODO Items
- Add validation when day and month are invalid i.e 30 Feb
- Add validation to ensure command is valid
- Combine validation into single validator based on ranges
- Add more writers, i.e to disk
- Add help on CLI interface