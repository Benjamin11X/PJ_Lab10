import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class BankInfo {
    private final String fileUrl = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

    public void findBankByPrefix() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Podaj trzy pierwsze cyfry konta: ");
            String accountPrefix = scanner.nextLine();

            if (!accountPrefix.matches("\\d{3}")) {
                System.out.println("Nieprawidłowy format. Wprowadź trzy cyfry.");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(fileUrl).openStream()))) {
                String line;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length >= 2 && parts[0].equals(accountPrefix)) {
                        String bankCode = parts[0];
                        String bankName = parts[1];
                        System.out.println("Numer banku: " + bankCode);
                        System.out.println("Nazwa banku: " + bankName);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Nie znaleziono banku dla podanego prefiksu.");
                }
            }
        } catch (Exception e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}
