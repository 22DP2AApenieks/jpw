//galvenā programma ar kuru programāa sāksies
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {


        //printē informāciju lietotājam, lai tas spētu lietot programmu
        System.out.println("Izvēlieties darbību:");
        System.out.println("1. Reģistrēt lietotāju");
        System.out.println("2. Ieiet litotāja profilā");
        System.out.println("3. Iziet");
        Scanner scanner = new Scanner(System.in);
        //izveidojam skeneri


        int izvele = Integer.valueOf(scanner.nextLine());
        if (izvele == 1){
            Registracija.registracija();
        } else if (izvele == 2){
            Ieiesana.ieiesana();
        } else {
            System.exit(0);
        }
        //izvēle salīdzina lietotāja ievadi un pēc tās novirza lietotāju uz reģistrāciju vai ieiešanu, vai beidz programmu
    }
}
