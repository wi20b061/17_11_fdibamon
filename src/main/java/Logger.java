import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    private static String path = "src/main/resources/results/";
    private static List<String> toOutput = new ArrayList<>();


    public void createReport(Fdibamon firstFdibamon, Fdibamon secondFdibamon) throws IOException {
        String fileName = generateFileName(firstFdibamon.getName(), secondFdibamon.getName());
        path = path + fileName + ".txt";
        StringBuilder out = new StringBuilder();

        for (String line : toOutput) {
            out.append(line);
        }
        Files.writeString(Path.of(path), String.format("%s", out));
    }

    public static void log(String message) {
        System.out.println(message);
        toOutput.add(message);
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
