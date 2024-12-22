import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\kmichala\\IdeaProjects\\PJ_Lab10\\src\\plik.txt";
        String outputFilePath = "C:\\Users\\kmichala\\IdeaProjects\\PJ_Lab10\\src\\plik_kopia.txt";

        // Try-with-resources dla automatycznego zarządzania zasobami
        try (FileReader reader = new FileReader(inputFilePath);
             FileWriter writer = new FileWriter(outputFilePath)) {

            int character;
            while ((character = reader.read()) != -1) {
                // Zamiana spacji na myślnik
                if (character == ' ') {
                    writer.write('-');
                } else {
                    writer.write(character);
                }
            }
            System.out.println("Plik został skopiowany z zamianą spacji na myślniki.");

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas kopiowania pliku: " + e.getMessage());
        }
    }
}
