import java.util.Scanner;
import java.util.ArrayList;

public class Galvenaprogrmma {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> Dalibnieki = new ArrayList<>();

        while (true) {
            System.out.println("Izvēlieties darbību:");
            System.out.println("1. Reģistrēt lietotāju");
            System.out.println("2. Ieiet litotāja profilā");
            System.out.println("3. Izvēlēties vingrinājumu"); //+ievadit skaitli
            System.out.println("4. Iziet");

            int izvele = Integer.valueOf(reader.nextLine());
            if (izvele == 1){
                Registracija.registracija();
            } else if (izvele == 2){
                Ieiesana.ieiesanasMetode();
            } else {
                break;
            }
        }
    }
}