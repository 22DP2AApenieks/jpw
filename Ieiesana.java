import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ieiesana {
    public static void main(String[] args) {
        programma();
    }

    public static void programma() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ievadi vārdu:");

        System.out.println("Vārds:");
        String nameToCheck = scanner.nextLine();

        String csvFile = "Dalibnieki.csv";  //noradu failu

        try {
            List<String> names = readNamesFromCsvFile(csvFile);

            if (containsName(names, nameToCheck)) {
                System.out.println("Tagad ievadi uzvārdu");
            } else {
                System.out.println("Nav. JA neesi reģistrēts izej un izveido profilu");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // Close the scanner to avoid resource leak
        }
    }

    private static List<String> readNamesFromCsvFile(String csvFile) throws IOException {
        List<String> names = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                // Assuming the CSV has a structure like "Name, Age, ...", adjust as needed
                String name = fields[0].trim();
                names.add(name);
            }
        }

        return names;
    }

    private static boolean containsName(List<String> names, String searchName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(searchName)) {
                return true;
            }
        }
        return false;
    }
}
