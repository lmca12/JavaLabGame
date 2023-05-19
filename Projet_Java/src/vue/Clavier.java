package vue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clavier {
    private static Scanner scanner = new Scanner(System.in);

    public static int entrerClavierInt() {
    	try {
    		int valeur = scanner.nextInt();
    		scanner.nextLine();
            return valeur;
        } catch (InputMismatchException e) {
            scanner.next(); // vider la ligne de saisie invalide
            System.out.println("Vous devez entrer un entier.");
            return entrerClavierInt(); // rappeler la méthode pour demander une saisie valide
        }
    }

    public static String entrerClavierString() {
        return scanner.nextLine();
    }

}
