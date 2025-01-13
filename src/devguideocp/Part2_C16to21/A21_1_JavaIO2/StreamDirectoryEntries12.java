package devguideocp.Part2_C16to21.A21_1_JavaIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hatzp
 **/
public class StreamDirectoryEntries12 {
    public static void main(String[] args) {

        Path wordFile = Path.of("wordlist.txt");
        System.out.println("Find palindromes, greater than length 2.");
        try (Stream<String> stream = Files.lines(wordFile)){
            List<String> palindromes = stream
                    .filter(str -> str.length() > 2)
                    .filter(str -> str.equals(new StringBuilder(str).reverse().toString()))
                    .toList();
            System.out.printf("List of palindromes:   %s%n", palindromes);
            System.out.printf("Number of palindromes: %s%n", palindromes.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //map to count the number of lines with different lengths
        Path textFile = Path.of("wordlist.txt");
        try (Stream<String> stream = Files.lines(textFile)) {
            java.util.Map<Integer, Long> grpMap =
                    stream.collect(Collectors.groupingBy(String::length,
                            Collectors.counting()));
            System.out.println(grpMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path dir = Path.of(".");
        System.out.printf("Immediate entries under directory \"%s\":%n", dir);
        try(Stream<Path> stream = Files.list(dir)) {
            stream.forEach(System.out::println);
        } catch (NotDirectoryException nde) {
            nde.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



    }
}
