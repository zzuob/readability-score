package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Text {

    public static String getTextFromFile(String path) {
        String result = "";
        try {
            result = new String(Files.readAllBytes(Path.of(path)));
        } catch (IOException e) {
            System.out.println("Error - Cannot read file at " + path);
            System.exit(-1);
        }
        return result;
    }
}
