import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Functional {
    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();

        var n = Files
                .lines(Paths.get(args[0]))
                .map(l -> l.length())
                .filter(size -> size > 0)
                .filter(size -> size > MIN_LENGTH)
                .reduce(0, Integer::sum);

        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }
}
