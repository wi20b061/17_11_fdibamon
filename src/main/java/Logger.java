import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.nio.file.Files.write;
import static java.nio.file.Files.writeString;

public class Logger {

    private static String path = "src/main/resources/results/";


    public void createReport(Fdibamon firstFdibamon, Fdibamon secondFdibamon, List<String> output) throws IOException {
        String fileName = generateFileName(firstFdibamon.getName(), secondFdibamon.getName());
        path = String.format(path + fileName + ".txt");
        for (String line : output) {
            Files.writeString(Path.of(path), String.format("%s%n", line));
        }
    }

    public static void log(String message, Path path) throws IOException {

    }

    private static String generateFileName(String firstFdibamonName, String secondFdibamonName) {
        StringBuilder fileName = new StringBuilder();
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("_dd-MM-yyyy_HH-mm-ss");
        fileName.append(firstFdibamonName)
                .append("-vs-")
                .append(secondFdibamonName)
                .append(currentTime.format(formatter));
        return fileName.toString();
    }
}
