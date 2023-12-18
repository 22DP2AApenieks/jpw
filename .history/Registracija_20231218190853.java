import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Registracija {
    private static ArrayList<String> Dalibnieki = new ArrayList<>();
        Scanner scanner = new Scanner(system.in);
        
    
        System.out.print("Ievadiet vārdu: ");
        String name = scanner.nextLine();
        
        System.out.print("Ievadiet uzvārdu: ");
        String surname = scanner.nextLine();
        
        System.out.print("Ievadiet pievilkšanās reižu rekordu: ");
        String pullups = scanner.nextLine();
        
        System.out.print("Ievadiet piepumpēšanās reižu rekordu: ");
        String pushups = scanner.nextLine();
        

        ArrayList<String> Dalibnieki = name + "," + surname + "," + pullups + "," + pushups;
        studentList.add(Dalibnieki);
        

    private static void saveToCSV(ArrayList<String> Dalibnieki) {
        try {
            FileWriter csvWriter = new FileWriter(Dalibnieki.csv, true); 

            for (String data : Dalibnieki) {
                csvWriter.append(Dalibnieki);
                csvWriter.append(", ");

                system.out.printline("");
                 
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("Student information has been saved to Dalibnieki.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Dalibnieki(String name, String surname, int pullups, int pushups) {
        this.name = name;
        this.surname = surname;
        this.pullups = pullups;
        this.pushups = pushups;
    }
}