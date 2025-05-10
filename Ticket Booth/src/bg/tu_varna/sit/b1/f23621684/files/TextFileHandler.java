package bg.tu_varna.sit.b1.f23621684.files;

import bg.tu_varna.sit.b1.f23621684.files.contracts.FileHandler;

import java.io.*;

public class TextFileHandler implements FileHandler {

    @Override
    public String readFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            if (file.getParentFile() != null)
                file.getParentFile().mkdirs();
            file.createNewFile();
        }

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line)
                    .append(System.lineSeparator());
        }
        reader.close();;
        return sb.toString();
    }

    @Override
    public void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            if (file.getParentFile() != null)
                file.getParentFile().mkdirs();
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(data);
        writer.close();
    }
}
