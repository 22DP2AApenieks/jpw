import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ieiesana {
    public static void ieiesana() {
        String csvFile = "Dalibnieki.csv";  // Replace with the actual path to your CSV file
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ievadiet vārdu: ");
            String name = scanner.nextLine();

            System.out.print("Ievadiet uzvārdu: ");
            String surname = scanner.nextLine();

            try {
                String lineWithUser = findLineWithUser(csvFile, name, surname);
                if (lineWithUser != null) {
     
                } else {
                    System.out.println("Lietotājs '" + name + " " + surname + " Neeksistē!");
                    return;
                }
                Programma.programma();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            

        }
    }

    private static String findLineWithUser(String csvFile, String name, String surname) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] fields = line.split(",");


                // Assuming there are 4 commas in each line
                if (fields.length == 4 && fields[0].trim().equals(name) && fields[1].trim().equals(surname)) {
                    System.out.println("Tu iegāji savā kontā! \n" + lineCount );
                    return line; // Line where both name and surname are found
                    
                }
            }
        }
        return null; // User not found in the CSV file
    }
}
