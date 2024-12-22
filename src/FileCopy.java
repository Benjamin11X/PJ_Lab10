import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    private final String inputFilePath;
    private final String outputFilePath;

    public FileCopy(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public void copyFileWithReplacement() {
        try (FileReader reader = new FileReader(inputFilePath);
             FileWriter writer = new FileWriter(outputFilePath)) {

            int character;
            while ((character = reader.read()) != -1) {
                if (character == ' ') {
                    writer.write('-');
                } else {
                    writer.write(character);
                }
            }
            System.out.println("Plik został skopiowany z zamianą spacji na myślniki.");
        } catch (IOException e) {
            System.out.println("Błąd podczas kopiowania pliku: " + e.getMessage());
        }
    }
}
