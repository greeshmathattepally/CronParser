import java.util.ArrayList;
import java.util.List;

public class CronParser {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("should have exactly one arg");
            return;
        }
        String cronString = args[0];
        String[] fields = cronString.split("\\s+");

        List<String> minute = expandField(fields[0], 0, 59);
        List<String> hour = expandField(fields[1], 0, 23);
        List<String> dayOfMonth = expandField(fields[2], 1, 31);
        List<String> month = expandField(fields[3], 1, 12);
        List<String> dayOfWeek = expandField(fields[4], 0, 7);

        System.out.println("minute " + String.join(" ", minute));
        System.out.println("hour " + String.join(" ", hour));
        System.out.println("day of month " + String.join(" ", dayOfMonth));
        System.out.println("month " + String.join(" ", month));
        System.out.println("day of week " + String.join(" ", dayOfWeek));
        System.out.println("command " + fields[5]);
    }

    static List<String> expandField(String field, int min, int max) {
        List<String> result = new ArrayList<>();
        String[] elements = field.split(",");

        for (String element : elements) {
            if (element.equals("*")) { // Handle asterisk (*) separately
                for (int i = min; i <= max; i++) {
                    result.add(String.valueOf(i));
                }
            } else if (element.contains("/")) {
                String[] stepElements = element.split("/");
                int start = min;
                int step = Integer.parseInt(stepElements[1]);
                if (!stepElements[0].equals("*")) {
                    start = Integer.parseInt(stepElements[0]);
                }
                for (int i = start; i <= max; i += step) {
                    if (i >= min && i <= max) {
                        result.add(String.valueOf(i));
                    }
                }
            } else if (element.contains("-")) {
                String[] rangeElements = element.split("-");
                int start = Integer.parseInt(rangeElements[0]);
                int end = Integer.parseInt(rangeElements[1]);
                for (int i = start; i <= end; i++) {
                    if (i >= min && i <= max) {
                        result.add(String.valueOf(i));
                    }
                }
            } else {
                int value = Integer.parseInt(element);
                if (value >= min && value <= max) {
                    result.add(element);
                }
            }
        }

        return result;
    }
}
