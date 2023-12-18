import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Registracija {
    private static ArrayList<String> Dalibnieki = new ArrayList<>();


    //         System.out.print("Ievadiet vārdu: ");
    //         String name = scanner.nextLine();

    //         System.out.print("Ievadiet uzvārdu: ");
    //         String surname = scanner.nextLine();

    //         System.out.print("Ievadiet pievilkšanās reižu rekordu: ");
    //         String pullups = scanner.nextLine();

    //         System.out.print("Ievadiet piepumpēšanās reižu rekordu: ");
    //         String pushups = scanner.nextLine();


// <<<<<<< main
//     //         String studentInfo = name + "," + surname + "," + pullups + "," + pushups;
//     //         studentList.add(studentInfo);
// =======
//             String studentInfo = name + "," + surname + "," + pullups + "," + pushups;
//             Dalibnieki.add(studentInfo);
// >>>>>>> main

    //         saveToCSV("Dalibnieki.csv", Dalibnieki);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    private static void saveToCSV(String fileName, ArrayList<String> dataList) {
        try {
            FileWriter csvWriter = new FileWriter(fileName, true); 

            for (String data : dataList) {
                csvWriter.append(data);
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("Student information has been saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registracija() {
        
    }
}

class Dalibnieki {
    public String name;
    public String surname;
    public int pullups;
    public int pushups;

    public Dalibnieks(String name, String surname, int pullups, int pushups) {
        this.name = name;
        this.surname = surname;
        this.pullups = pullups;
        this.pushups = pushups;
    }
}