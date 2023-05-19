package structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe contenant des méthodes pour sauvegarder, charger, afficher et vérifier
 * l'existence des sauvegardes du labyrinthe.
 */
public class Save {
	/**
	 * Sauvegarde un objet Labyrinthe dans un fichier avec le nom spécifié.
	 *
	 * @param labyrinthe Labyrinthe à sauvegarder
	 * @param nomFichier Nom du fichier de sauvegarde
	 */
	public static void sauvegarderLabyrinthe(Labyrinthe labyrinthe, String nomFichier) {
		String chemin = "./src/save/" + nomFichier;
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(chemin))) {
			oos.writeObject(labyrinthe);
			System.out.println("Labyrinthe sauvegardé avec succès !");
		} catch (IOException e) {
			System.err.println("Erreur lors de la sauvegarde du labyrinthe : " + e.getMessage());
		}
	}

	/**
	 * Charge un objet Labyrinthe depuis un fichier avec le nom spécifié.
	 *
	 * @param nomFichier Nom du fichier de sauvegarde à charger
	 * @return Labyrinthe chargé depuis le fichier
	 */
	public static Labyrinthe chargerLabyrinthe(String nomFichier) {
		String chemin = "./src/save/" + nomFichier;
		Labyrinthe labyrinthe = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(chemin))) {
			labyrinthe = (Labyrinthe) ois.readObject();
			System.out.println("Labyrinthe chargé avec succès !");
		} catch (IOException e) {
			System.err.println("Erreur lors du chargement du labyrinthe : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Erreur lors du chargement du labyrinthe : " + e.getMessage());
		}
		return labyrinthe;
	}

	/**
	 * Affiche la liste des fichiers de sauvegarde de labyrinthe disponibles.
	 */
	public static void afficherSauvegardes() {
		File sauvegardesDir = new File("./src/save/");
		if (sauvegardesDir.exists() && sauvegardesDir.isDirectory()) {
			File[] fichiers = sauvegardesDir.listFiles();

			if (fichiers != null && fichiers.length > 0) {
				System.out.println("Liste des sauvegardes : ");
				for (int i = 0; i < fichiers.length; i++) {
					System.out.println((i + 1) + ". " + fichiers[i].getName());
				}
			} else {
				System.out.println("Aucune sauvegarde trouvée.");
			}
		} else {
			System.out.println("Le dossier de sauvegardes n'existe pas.");
		}

	}

	/**
	 * Retourne le nombre de fichiers de sauvegarde de labyrinthe disponibles.
	 *
	 * @return Le nombre de fichiers de sauvegarde de labyrinthe disponibles.
	 */
	public static int NbrSauvegardes() {
		File sauvegardesDir = new File("./src/save/");
		if (sauvegardesDir.exists() && sauvegardesDir.isDirectory()) {
			File[] fichiers = sauvegardesDir.listFiles();

			if (fichiers != null && fichiers.length > 0) {
				return fichiers.length;
			} else {
				System.out.println("Aucune sauvegarde trouvée.");
				return -1;
			}
		} else {
			System.out.println("Le dossier de sauvegardes n'existe pas.");
			return -1;
		}

	}

	/**
	 * Vérifie si une sauvegarde avec le nom de fichier spécifié existe.
	 *
	 * @param file Nom du fichier de sauvegarde à vérifier l'existence
	 * @return true si le fichier existe, false sinon
	 */
	public static boolean SauvgardeExiste(String file) {
		File sauvegardesDir = new File("./src/save/" + file);
		if (sauvegardesDir.exists()) {
			return true;
		}
		return false;

	}

}
