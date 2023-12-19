import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ieiesana {
    public static void ieiesanasMetode() {
        programma();
    }

    public static void programma() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ievadi vārdu un uzvārdu:");

        System.out.println("Vārds:");
        String nameToCheck = scanner.nextLine();

        System.out.println("Uzvārds:");
        String surnameToCheck = scanner.nextLine();

        String csvFile = "Dalibnieki.csv";  

        try {
            List<String> mekletajs = readDataFromCsvFile(csvFile);

            if (containsData(mekletajs, nameToCheck, surnameToCheck)) {
                System.out.println("Tu esi iekšā!");
            } else {
                System.out.println("Nepareizi ievadīts vārds vai uzvārds");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static List<String> readDataFromCsvFile(String csvFile) throws IOException {
        List<String> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        }

        return records;
    }

    private static boolean containsData(List<String> records, String searchName, String searchSurname) {
        for (String record : records) {
            String[] fields = record.split(",");
            String name = fields[0].trim();
            String surname = fields[1].trim();
            if (name.equalsIgnoreCase(searchName) && surname.equalsIgnoreCase(searchSurname)) {
                return true;
            }
        }
        return false;
    }
}
