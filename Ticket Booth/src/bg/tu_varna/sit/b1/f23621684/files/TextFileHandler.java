package bg.tu_varna.sit.b1.f23621684.files;

import bg.tu_varna.sit.b1.f23621684.files.contracts.FileHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileHandler implements FileHandler {

    @Override
    public String readFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        return Files.readString(filePath, StandardCharsets.UTF_8);
    }

    @Override
    public void writeFile(String path, String data) throws IOException {
        Path filePath = Paths.get(path);
        Files.writeString(filePath, data, StandardCharsets.UTF_8);
    }
}
