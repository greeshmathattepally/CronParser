import java.util.List;

public class CronParserTest {
    public static void main(String[] args) {
        testExpandFieldWithAsterisk();
        testExpandFieldWithRange();
        testExpandFieldWithStep();
        testExpandFieldWithSingleValue();
        testExpandFieldWithInvalidValue();
        testExpandFieldWithStepAndStartValue();
    }

    private static void testExpandFieldWithAsterisk() {
        List<String> result = CronParser.expandField("*", 0, 59);
        System.out.println("Expected: 0 1 2 ... 59");
        System.out.println("Actual: " + String.join(" ", result));
    }

    private static void testExpandFieldWithRange() {
        List<String> result = CronParser.expandField("10-20", 0, 59);
        System.out.println("Expected: 10 11 12 ... 20");
        System.out.println("Actual: " + String.join(" ", result));
    }

    private static void testExpandFieldWithStep() {
        List<String> result = CronParser.expandField("*/15", 0, 59);
        System.out.println("Expected: 0 15 30 45");
        System.out.println("Actual: " + String.join(" ", result));
    }

    private static void testExpandFieldWithSingleValue() {
        List<String> result = CronParser.expandField("5", 0, 59);
        System.out.println("Expected: 5");
        System.out.println("Actual: " + String.join(" ", result));
    }

    private static void testExpandFieldWithInvalidValue() {
        List<String> result = CronParser.expandField("70-80", 0, 59);
        System.out.println("Expected: (empty list)");
        System.out.println("Actual: " + String.join(" ", result));
    }

    private static void testExpandFieldWithStepAndStartValue() {
        List<String> result = CronParser.expandField("5/15", 0, 59);
        System.out.println("Expected: 5 20 35 50");
        System.out.println("Actual: " + String.join(" ", result));
    }
}

