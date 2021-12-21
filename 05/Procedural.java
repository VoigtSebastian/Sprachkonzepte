import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class Procedural {
    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Files.newBufferedReader(Paths.get(args[0]));
        var lines = new LinkedList<String>();

        long start = System.nanoTime();

        readLines(input, lines);
        removeEmptyLines(lines);
        removeShortLines(lines);
        int n = totalLineLengths(lines);

        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }

    static void readLines(BufferedReader input, List<String> lines) throws IOException {
        String line;
        while ((line = input.readLine()) != null) {
            lines.add(line);
        }
        input.close();
    }

    static void removeEmptyLines(List<String> lines) {
        lines.removeIf(s -> s.isEmpty());
    }

    static void removeShortLines(List<String> lines) {
        lines.removeIf(s -> s.length() < MIN_LENGTH);
    }

    static int totalLineLengths(List<String> lines) {
        int counter = 0;
        for (String line : lines) {
            counter += line.length();
        }
        return counter;
    }
}
