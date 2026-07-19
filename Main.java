import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("     FILE ORGANIZER SYSTEM");
        System.out.println("=======================================");

        System.out.print("Enter the folder path to organize: ");
        String folderPath = scanner.nextLine();

        FileOrganizer organizer = new FileOrganizer();

        organizer.organizeFiles(folderPath);

        System.out.println("\n=======================================");
        System.out.println(" File Organization Completed!");
        System.out.println("=======================================");

        scanner.close();
    }
}
