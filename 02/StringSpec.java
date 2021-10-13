import java.util.regex.Pattern;
import java.util.regex.Matcher;

public final class StringSpec {
    static String ARGUMENT_INDEX = "(\\d+$)?";
    static String FLAGS = "[-#+ 0,(]*";
    static String WIDTH = "\\d*";
    static String PRECISION = "(\\.\\d++)*";
    static String DATE_TIME = "[tT]?";
    static String CONVERSION = "[a-zA-Z%]";
    static String PATTERN = "(%" + ARGUMENT_INDEX + FLAGS + WIDTH + PRECISION + DATE_TIME + CONVERSION + ")";

    private StringSpec() {
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("java RegexTest <format-string>");
            System.exit(1);
        }
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(args[0]);

        String fullText = args[0];
        String currentText = "";
        int subStringStart = 0;

        while (matcher.find()) {
            currentText = fullText.substring(subStringStart, matcher.start());
            subStringStart = matcher.end();

            printText(currentText);
            printFormat(matcher.group());
        }
        currentText = fullText.substring(subStringStart);
        printText(currentText);

        System.out.println("\n");
    }

    private static void printText(String text) {
        if (!text.isEmpty())
            System.out.printf("Text(%s)", text);
    }

    private static void printFormat(String format) {
        System.out.printf("FORMAT(%s)", format);
    }
}
