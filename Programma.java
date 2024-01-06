import java.io.*;
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
                // Display user profile header
                System.out.println("\u001b[43mLietotāja profils\nVārds, uzvārds, pievilkšanās rekkords, piepumpēšanās rekords\n\u001b[0m" + lineWithUser );

                // Split the string using commas
                String[] values = lineWithUser.split(",");
                System.out.println("Ievadi pievilkšanās reižu skaitu: ");
                int pullups = Integer.valueOf(scanner.nextLine());

                // Check if there are at least four values in the array
                if (values.length >= 4) {
                    // Extract pull-up record
                    String pullupRecord = values[2].trim();

                    // Validate if the record is a valid integer
                    try {
                        int pullupResult = Integer.parseInt(pullupRecord);

                        // Compare pull-ups with the extracted value
                        if (pullups == pullupResult) {
                            System.out.println("Atkārtots pievilkšanās rekords!");
                        } else if (pullups > pullupResult) {
                            System.out.println("\u001b[42mJauns personīgais pievilkšanās rekords " + pullups + " reizes! \nApsveicu! \u001b[0m");
                        } else {
                            System.out.println("\u001b[41mNav jauns pievilkšanās rekords! \u001b[0m");
                        }

                        // Now, check push-ups
                        System.out.println("Ievadi piepumpēšanās reižu skaitu: ");
                        int pushups = Integer.valueOf(scanner.nextLine());

                        // Extract push-up record
                        String pushupRecord = values[3].trim();

                        // Validate if the record is a valid integer
                        try {
                            int pushupResult = Integer.parseInt(pushupRecord);

                            // Compare push-ups with the extracted value
                            if (pushups == pushupResult) {
                                System.out.println("Atkārtots piepumpēšanās rekords!");
                            } else if (pushups > pushupResult) {
                                System.out.println("\u001b[42mJauns personīgais piepumpēšanās rekords " + pushups + " reizes! \nApsveicu!\u001b[0m");
                            } else {
                                System.out.println("\u001b[41mNav jauns piepumpēšanās rekords!\u001b[0m");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Kļūda");
                        }

                        // Check if user wants to update records
                        System.out.println("Vai vēlaties atjaunināt datus? (Ievadiet 'j'-jā vai 'n'-nē):");
                        String updateChoice = scanner.nextLine().trim().toLowerCase();

                        if ("j".equals(updateChoice)) {
                            updateRecords(csvFile, indekss, pullups, pushups);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Kļūda");
                    }
                } else {
                    System.out.println("Kļūda");
                }
            } else {
                System.out.println("Nepareizs numurs");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateRecords(String csvFile, int indekss, int newPullups, int newPushups) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(csvFile))) {
            StringBuilder inputBuffer = new StringBuilder();
            String line;

            int lineCount = 0;
            while ((line = fileReader.readLine()) != null) {
                lineCount++;

                if (lineCount == indekss) {
                    // Update the line with new pull-up and push-up records
                    String[] values = line.split(",");
                    values[2] = String.valueOf(newPullups);
                    values[3] = String.valueOf(newPushups);
                    line = String.join(",", values);
                }

                inputBuffer.append(line).append("\n");
            }

            // Write the updated content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                writer.write(inputBuffer.toString());
            }
        }
        System.out.println("Dati atjaunoti!");
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
