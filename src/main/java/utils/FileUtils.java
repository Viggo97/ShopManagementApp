package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void createNewFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
    }

    public static void clearFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.close();
    }
}
