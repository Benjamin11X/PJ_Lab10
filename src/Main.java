import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Użycie klasy FileCopy
        String inputFilePath = "C:\\Users\\kmichala\\IdeaProjects\\PJ_Lab10\\src\\plik.txt";
        String outputFilePath = "C:\\Users\\kmichala\\IdeaProjects\\PJ_Lab10\\src\\plik_kopia.txt";

        FileCopy fileCopy = new FileCopy(inputFilePath, outputFilePath);
        fileCopy.copyFileWithReplacement();

        // Użycie klasy BankInfo
        BankInfo bankInfo = new BankInfo();
        bankInfo.findBankByPrefix();
    }
}
