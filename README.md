# CronParser
CronParser is a simple Java command line application that parses a cron string and expands each field to show the times at which it will run.

CronParser.java: Contains the main application code that parses and expands the cron string.
CronParserTest.java: Contains test cases for CronParser.java.


To use the CronParser application, run the following command in the terminal, follow below steps
1. Open the terminal/CMD and navigate to the CronParser directory.
2. Compile source files using the javac command:
      javac CronParser.java
3. run the following command in the terminal
       java -cp . CronParser "*/15 0 1,15 * 1-5 /usr/bin/find"


How to Run Tests(with test class provided) : 
To run the test cases for the CronParser application, follow these steps:

1. Open the terminal/CMD and navigate to the CronParser directory.
2. Compile both source files (main code and test code) using the javac command:
      javac CronParser.java CronParserTest.java
3. Run the test class using the java command:
      java CronParserTest
The test output will be displayed in the terminal, showing the expected and actual results for each test case.


Additional Notes :

The CronParser application only considers the standard cron format with five time fields (minute, hour, day of month, month, and day of week) plus a command. Special time strings like "@yearly" are not handled.
