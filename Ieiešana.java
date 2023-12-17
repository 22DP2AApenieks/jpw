public class Ieiešana {
    public static void Ieiešana(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> Dalibnieki = new ArrayList<>()

        while (true) {
            System.out.println("Izvēlieties darbību:");
            System.out.println("1. Reģistrēt lietotāju");
            System.out.println("2. Ieiet litotāja profilā");
            System.out.println("3. Izvēlēties vingrinājumu"); //+ievadit skaitli
            System.out.println("4. Iziet");

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                Registracija.user(args);
                
                case 2:
                    System.out.println("Studentu saraksts:");
                    showStudents();
                    break;
                
                case 3:
                    System.out.print("Ievadiet studenta vārdu, kuru vēlaties izņemt: ");
                    String removeName = scanner.nextLine(); 
                
                    boolean removalSuccessful = false;
                
                    ArrayList<String> studentsToRemove = new ArrayList<>();
                
                    for (String student : studentList) {
                        if (student.contains(removeName)) {
                            studentsToRemove.add(student);
                            removalSuccessful = true;
                        }
                    }
                
                    if (removalSuccessful) {
                        studentList.removeAll(studentsToRemove);
                        System.out.println("Studenta dati iznemti veiksmīgi.");
                    } else {
                        System.out.println("Studenta datu izņemšana neizdevās.");
                    }
                    break;
                
                case 4:
                    System.out.println("Programma tiek izbeigta.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Nepareiza darbība. Lūdzu, izvēlieties atkal.");
            }
        }
    }

    public static void showStudents() {
        ArrayList<String> studentList = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader("fails.csv"))) {
            while ((line = reader.readLine()) != null) {
                studentList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!studentList.isEmpty()) {
            for (String student : studentList) {
                System.out.println(student);
            }
        }
    }
}
            
        }
    }
}