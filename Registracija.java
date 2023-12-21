import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Registracija {
    private static ArrayList<String> Dalibniekussaraksts = new ArrayList<>();

    public static void registracija() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ievadiet vārdu: ");
            String name = scanner.nextLine();

            System.out.print("Ievadiet uzvārdu: ");
            String surname = scanner.nextLine();

            System.out.print("Ievadiet pievilkšanās reižu rekordu: ");
            String pullups = scanner.nextLine();

            System.out.print("Ievadiet piepumpēšanās reižu rekordu: ");
            String pushups = scanner.nextLine();

            String Dalibnieki = name + "," + surname + "," + pullups + "," + pushups;
            Dalibniekussaraksts.add(Dalibnieki);

            // Save new user information to CSV file
            saveToCSV("Dalibnieki.csv", Dalibniekussaraksts);

            // Check if the user exists in the CSV file after saving
            String csvFile = "Dalibnieki.csv";
            try {
                LineAndUserDetails result = findLineWithUser(csvFile, name, surname);
                if (result != null) {
                    System.out.println("Tavs iegāji savā kontā!");
                    System.out.println("Lietotājs atrodas rindā: " + result.lineNumber);
                } else {
                    System.out.println("Lietotājs '" + name + " " + surname + "' Neeksistē!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Continue with the main program
            Programma.programma();

        } finally {
            // Any cleanup code can go here
        }
    }

    private static LineAndUserDetails findLineWithUser(String csvFile, String name, String surname) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] fields = line.split(",");

                // Assuming there are 4 fields in each line
                if (fields.length == 4 && fields[0].trim().equals(name) && fields[1].trim().equals(surname)) {
                    System.out.println("Tavs iegāji savā kontā! \n" + line);
                    return new LineAndUserDetails(line, lineCount);
                }
            }
        }
        return null; // User not found in the CSV file
    }

    private static void saveToCSV(String fileName, ArrayList<String> dataList) {
        try {
            FileWriter csvWriter = new FileWriter(fileName, true);

            for (String data : dataList) {
                csvWriter.append(data);
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("Dalībnieka informācija saglabāta " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registracijaMetode() {
        // Any additional registration logic can go here
    }

    // Helper class to hold line details
    private static class LineAndUserDetails {
        String line;
        int lineNumber;

        LineAndUserDetails(String line, int lineNumber) {
            this.line = line;
            this.lineNumber = lineNumber;
        }
    }
}
