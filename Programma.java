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
                
                // Split the string using commas
                String[] values = lineWithUser.split(",");
                System.out.println("Ievadi pievilkšanās reižu skaitu: ");
                int pullups = Integer.valueOf(scanner.nextLine());

                // Check if there are at least four values in the array
                if (values.length >= 4) {
                    // Extract the value between the third and fourth comma
                    String valueToParse = values[2].trim(); // Trim to remove leading/trailing spaces

                    // Validate if the valueToParse is a valid integer
                    try {
                        int result = Integer.parseInt(valueToParse);

                        // Compare pullups with the extracted value
                        if (pullups == result) {
                            System.out.println("Atkārtots rekords!");
                        } else if (pullups > result) {
                            System.out.println("Jauns personīgais rekords " + pullups + " pievilkšanās reižu! \nApsveicu!");
                        } else {
                            System.out.println("Nav jauns rekords!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format for the value between the third and fourth comma.");
                    }
                } else {
                    System.out.println("Not enough values in the variable.");
                }
            } else {
                System.out.println("Nepareizs numurs");
                return;
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
