import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Programma {
    public static void programma() {

        String csvFile = "Dalibnieki.csv";
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ievadi šo skaitli lai palaistu programmu!(virs šī teksta)");
            int indekss = Integer.valueOf(scanner.nextLine());

            String lineWithUser = findLineWithUser(csvFile, indekss);
            if (lineWithUser != null) {
                System.out.println("Lietotāja profils\n" + "Vārds, uzvārds, pievilkšanās rekkords, piepumpēšanās rekords\n" + lineWithUser);
            } else {
                System.out.println("Lietotājs Neeksistē!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String findLineWithUser(String csvFile, int indekss) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                if (lineCount == indekss) {
                    return line; // Line at the specified index
                }
            }
        }
        return null; // Index not found in the CSV file
    }
}
