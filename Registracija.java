
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
//šis fails atvērsies ja lietotāja izvēle būs 1-reģistrēties
public class Registracija {
    private static ArrayList<String> Dalibniekussaraksts = new ArrayList<>();

    public static void registracijaMetode(){
        try {
            Scanner scanner = new Scanner(System.in);
        //uztaisu skeneri
            System.out.print("Ievadiet vārdu: ");
            String name = scanner.nextLine();

            System.out.print("Ievadiet uzvārdu: ");
            String surname = scanner.nextLine();

            System.out.print("Ievadiet pievilkšanās reižu rekordu: ");
            String pullups = scanner.nextLine();

            System.out.print("Ievadiet piepumpēšanās reižu rekordu: ");
            String pushups = scanner.nextLine();
            //saglabāju dažādu informāciju par lietotāju


            String Dalibnieki = name + "," + surname + "," + pullups + "," + pushups;
            Dalibniekussaraksts.add(Dalibnieki);
            //apkiopo ievadītos datus

            //sakas datu saglabāšana csv faila
            saveToCSV("Dalibnieki.csv", Dalibniekussaraksts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveToCSV(String fileName, ArrayList<String> dataList) {
        try {
            FileWriter csvWriter = new FileWriter(fileName, true); 

            for (String data : Dalibniekussaraksts) {
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
    

    public static void registracija() {
        
    }
}

class Dalibnieks {
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
